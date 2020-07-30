package org.shop.db;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import org.shop.db.entity.OrderDetailEntity;
import org.shop.db.entity.OrderEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrdersRepository {

    private static final String URL = "jdbc:mysql://localhost:3306/shopdb?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    @Override
    public List<OrderEntity> findAllOrdersInDB() {

        List<OrderEntity> orders = new ArrayList<>();
        String selectquery = "SELECT *FROM `order`";
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
                OrderDetailRepositoryImpl orderDetailRepository = new OrderDetailRepositoryImpl();
                List<OrderDetailEntity> orderDetailEntittes = orderDetailRepository.findAllDetailInCurrentOrder(id);
                String name = result.getString("name");
                String client = result.getString("client");
                orders.add(new OrderEntity(id, name, client, orderDetailEntittes));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;


    }

    @Override
    public OrderEntity findOrderByID(long id) {
        return null;
    }

    @Override
    public void saveOrderInDB(OrderEntity orderEntity) {

    }

    @Override
    public void deleteOrderFromDB(long orderId) {

    }
}
