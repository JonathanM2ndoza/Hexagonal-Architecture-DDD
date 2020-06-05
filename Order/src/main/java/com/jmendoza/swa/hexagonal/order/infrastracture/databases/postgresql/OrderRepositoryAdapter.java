package com.jmendoza.swa.hexagonal.order.infrastracture.databases.postgresql;

import com.google.gson.Gson;
import com.jmendoza.swa.hexagonal.order.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.order.domain.model.Order;
import com.jmendoza.swa.hexagonal.order.domain.ports.outbound.CreateOrderPort;
import com.jmendoza.swa.hexagonal.order.domain.ports.outbound.GetOrderPort;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

@Repository
public class OrderRepositoryAdapter implements CreateOrderPort, GetOrderPort {

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
