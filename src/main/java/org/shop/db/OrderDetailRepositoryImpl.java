package org.shop.db;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import org.shop.db.entity.OrderDetailEntity;
import org.shop.db.entity.OrderEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailRepositoryImpl implements OrderDetailsRepository {

    private static final String URL = "jdbc:mysql://localhost:3306/shopdb?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    @Override
    public List<OrderDetailEntity> findAllDetailInCurrentOrder(long orderID) {
        List<OrderDetailEntity> detail = new ArrayList<>();
        String selectquery = "SELECT *FROM orderdetail WHERE order_id=" + orderID;
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("Не удалось загрузить драйвер!!!");

        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); Statement statement = connection.createStatement()) {

            ResultSet result = statement.executeQuery(selectquery);
            while (result.next()) {
                long id = result.getLong("id");
                String name = result.getString("name");
                Double price = result.getDouble("price");
                detail.add(new OrderDetailEntity(id, name, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detail;
    }

    @Override
    public OrderDetailEntity findDetailByIDinCurrentOrder(long id, long order_id) {

        String selectquery = "SELECT* FROM orderdetail WHERE id=" + id + " AND order_id=" + order_id;

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("Не удалось загрузить драйвер!!!");

        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); Statement statement = connection.createStatement()) {

            ResultSet result = statement.executeQuery(selectquery);
            while (result.next()) {
                String name = result.getString("name");
                Double price = result.getDouble("price");
                return new OrderDetailEntity(id, name, price);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }


    @Override
    public void deleteOrderDetailFromDB(long orderId) {

    }
}


