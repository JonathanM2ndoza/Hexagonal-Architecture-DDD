package com.jmendoza.swa.hexagonal.infrastracture.databases.postgresql;

import com.google.gson.Gson;
import com.jmendoza.swa.hexagonal.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.domain.model.Order;
import com.jmendoza.swa.hexagonal.domain.ports.outbound.GetOrderPort;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

@Component
public class GetOrderAdapter implements GetOrderPort {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Order getOrder(String orderId) throws GlobalException {

        final String procedureCall = "{ ? = call get_order(?)}";
        Order order = null;

        try (Connection connection = jdbcTemplate.getDataSource().getConnection();
             CallableStatement callableStatement = connection.prepareCall(procedureCall)
        ) {
            PGobject pGobject;

            callableStatement.registerOutParameter(1, Types.OTHER);
            callableStatement.setLong(2, Long.parseLong(orderId));
            callableStatement.execute();

            pGobject = (PGobject) callableStatement.getObject(1);
            if (pGobject != null) {
                Gson gson = new Gson();
                order = gson.fromJson(pGobject.toString(), Order.class);
            }

        } catch (Exception e) {
            throw new GlobalException("Exception getOrder: " + e.getMessage());
        }
        return order;
    }
}
