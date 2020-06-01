package com.jmendoza.swa.hexagonal.order.infrastracture.databases.postgresql;

import com.jmendoza.swa.hexagonal.order.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.order.domain.model.Order;
import com.jmendoza.swa.hexagonal.order.domain.ports.outbound.CreateOrderPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

@Repository
public class OrderRepositoryAdapter implements CreateOrderPort {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createOrder(Order order) throws GlobalException {

        final String procedureCall = "{call PROC_XXXX(?, ?, ?)}";

        try (Connection connection = jdbcTemplate.getDataSource().getConnection();
             CallableStatement callableStatement = connection.prepareCall(procedureCall)
        ) {
            callableStatement.setString(1, "XXXX");
            callableStatement.setString(2, " XXXX");
            callableStatement.registerOutParameter(3, Types.VARCHAR);

            callableStatement.execute();
            callableStatement.getString(3);
        } catch (Exception e) {
            throw new GlobalException("createOrder", e);
        }
    }
}
