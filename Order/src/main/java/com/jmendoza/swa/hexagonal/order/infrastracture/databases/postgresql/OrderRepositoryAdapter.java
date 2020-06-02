package com.jmendoza.swa.hexagonal.order.infrastracture.databases.postgresql;

import com.jmendoza.swa.hexagonal.order.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.order.domain.model.Order;
import com.jmendoza.swa.hexagonal.order.domain.ports.outbound.CreateOrderPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;

@Repository
public class OrderRepositoryAdapter implements CreateOrderPort {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createOrder(Order order) throws GlobalException {

        final String procedureCall = " call create_order(?, ?, ?) ";

        try (Connection connection = jdbcTemplate.getDataSource().getConnection();
             CallableStatement callableStatement = connection.prepareCall(procedureCall)
        ) {
            callableStatement.setString(1, order.getCustomerId());
            callableStatement.setTimestamp(2, new java.sql.Timestamp(order.getCreatedAt().getTime()));
            callableStatement.setDouble(3, order.getAmountOrder());
            //callableStatement.registerOutParameter(4, Types.INTEGER);

            callableStatement.execute();
            //order.setId(Integer.toString(callableStatement.getInt(4)));
        } catch (Exception e) {
            throw new GlobalException("Exception createOrder: " + e.getMessage());
        }
    }
}
