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
        String selectAllDetailsOfThisOrderQuery = "SELECT * FROM order_details_table WHERE orderID = " + orderId;
        try (Statement stmnt = conn.createStatement()) {
            ResultSet resultSetOfOrderDetails = stmnt.executeQuery(selectAllDetailsOfThisOrderQuery);
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
    public OrderDetailEntity getDetailByID(long detailId) {
        String selectDetailByIdQuery = String.format("SELECT * from order_details_table WHERE order_details_table.id = %d;", detailId);
        try (Statement stmnt = conn.createStatement()) {
            ResultSet resultSetByDetailId = stmnt.executeQuery(selectDetailByIdQuery);
            while (resultSetByDetailId.next()) {
                String detailName = resultSetByDetailId.getString("name");
                double price = resultSetByDetailId.getDouble("price");
                long orderId = resultSetByDetailId.getLong("orderID");
                System.out.println("Detail entity with id=" + detailId + " is contained in order with id=" + orderId);
                return new OrderDetailEntity(detailId, detailName, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("No such order detail in DB! ");
        return null;
    }

    @Override
    public void addDetailToOrder(long orderId, OrderDetailEntity orderDetail) {
        String insertDetailQuery = "insert into order_details_table (name, price, orderID) values ('"
                + orderDetail.getDetailName() + "', " + orderDetail.getPrice() + ", " + orderId + ");";
        try (Statement stmnt = conn.createStatement()) {
            System.out.println("Quantity of added order details: " + stmnt.executeUpdate(insertDetailQuery));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDetailFromOrder(long detailId) {
        String deleteDetailQuery = String.format("delete from order_details_table where id=%d;", detailId);
        try (Statement stmnt = conn.createStatement()) {
            System.out.println("Quantity of deleted order details: " + stmnt.executeUpdate(deleteDetailQuery));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
