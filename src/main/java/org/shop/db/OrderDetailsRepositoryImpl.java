package org.shop.db;

import org.shop.db.entity.OrderDetailEntity;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDetailsRepositoryImpl implements OrderDetailsRepository {

    private Connection conn;

    public OrderDetailsRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<OrderDetailEntity> getOrderDetailList(long orderId) {
        List<OrderDetailEntity> orderDetailEntities = new ArrayList<>();
        String selectAllDetailsOfThisOrdersQuery = "SELECT * FROM order_details_table WHERE orderID = " + orderId;
        try (Statement stmnt = conn.createStatement()) {
            ResultSet resultSetOfOrderDetails = stmnt.executeQuery(selectAllDetailsOfThisOrdersQuery);
            while (resultSetOfOrderDetails.next()) {
                long detailId = resultSetOfOrderDetails.getLong("id");
                String detailName = resultSetOfOrderDetails.getString("name");
                double price = resultSetOfOrderDetails.getDouble("price");
                orderDetailEntities.add(new OrderDetailEntity(detailId, detailName, price));
            }
            return orderDetailEntities;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public OrderDetailEntity getDetailByID(long orderId, long detailId) {
        return null;
    }

    @Override
    public void addDetailToOrder(long orderId, OrderDetailEntity orderDetail) {

    }

    @Override
    public boolean deleteDetailFromOrder(long orderId, long detailId) {
        return false;
    }
}
