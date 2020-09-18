package com.jmendoza.swa.hexagonal.infrastracture.databases.postgresql;

import com.google.gson.Gson;
import com.jmendoza.swa.hexagonal.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.domain.model.Order;
import com.jmendoza.swa.hexagonal.domain.ports.outbound.CreateOrderPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

@Component
public class CreateOrderAdapter implements CreateOrderPort {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CreateOrderAdapter(final DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createOrder(Order order) throws GlobalException {

        final String procedureCall = "{ ? = call create_order(?, ?, ?, ?)}";

        try (Connection connection = jdbcTemplate.getDataSource().getConnection();
             CallableStatement callableStatement = connection.prepareCall(procedureCall)
        ) {
            Gson gson = new Gson();
            String json = gson.toJson(order.getOrderProductList());

            callableStatement.registerOutParameter(1, Types.BIGINT);
            callableStatement.setString(2, order.getCustomerId());
            callableStatement.setTimestamp(3, new java.sql.Timestamp(order.getCreatedAt().getTime()));
            callableStatement.setDouble(4, order.getAmountOrder());
            callableStatement.setString(5, json);

            callableStatement.execute();

            order.setOrderId(Long.toString(callableStatement.getLong(1)));
        } catch (Exception e) {
            throw new GlobalException("Exception createOrder: " + e.getMessage());
        }
    }
}
