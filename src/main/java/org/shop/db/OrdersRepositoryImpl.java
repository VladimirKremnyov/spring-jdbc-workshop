package org.shop.db;

import org.shop.db.entity.OrderDetailEntity;
import org.shop.db.entity.OrderEntity;

import java.sql.*;
import java.util.*;

public class OrdersRepositoryImpl implements OrdersRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/practice_one_jdbc?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "653241";

    public static void main(String[] args) {
        OrdersRepository ordersRepository = new OrdersRepositoryImpl();
        ordersRepository.addOrder(new OrderEntity("fffff", "client5",
                Arrays.asList(new OrderDetailEntity("det5", 15.5),
                new OrderDetailEntity("det6", 16.5))));
    }

    @Override
    public List<OrderEntity> gatAllOrders() {
        String selectAllOrders = "SELECT o.order_id AS o_id, o.order_name AS o_name, o.client_name AS o_client_name, " +
                "od.detail_id AS od_id, od.detail_name AS od_name, od.detail_price AS od_price, od.order_id AS od_order_id " +
                "FROM order_entity o LEFT JOIN order_detail_entity od ON o.order_id = od.order_id;";
        Map<Long, OrderEntity> idOnDetails = new HashMap<>();
        try {
            Connection connection = connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectAllOrders);
            while (resultSet.next()) {
                long id = resultSet.getLong("o_id");
                String orderName = resultSet.getString("o_name");
                String clientName = resultSet.getString("o_client_name");
                Long detailId = resultSet.getLong("od_id");
                String detailName = resultSet.getString("od_name");
                double detailPrice = resultSet.getDouble("od_price");
                OrderEntity orderEntity = idOnDetails.get(id);
                if (orderEntity != null) {
                    addDetailIfPresent(detailId, detailName, detailPrice, orderEntity);
                } else {
                    OrderEntity entity = new OrderEntity(id, orderName, clientName, new ArrayList<OrderDetailEntity>());
                    addDetailIfPresent(detailId, detailName, detailPrice, entity);
                    idOnDetails.put(id, entity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(idOnDetails.values());
    }

    private void addDetailIfPresent(Long detailId, String detailName, double detailPrice, OrderEntity orderEntity) {
        if (detailName != null){
            orderEntity.getOrderDetailEntities().add(new OrderDetailEntity(detailId, detailName, detailPrice));
        }
    }

    @Override
    public void addOrder(OrderEntity orderEntity) {
//        String selectOrderID = "SELECT o.order_id FROM order_entity o";
        String orderName = orderEntity.getName();
        String clientName = orderEntity.getClient();
        List<OrderDetailEntity> orderDetailEntityList = new ArrayList<>(orderEntity.getOrderDetailEntities());
        try (Connection connection = connection(); Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            statement.addBatch("INSERT INTO order_entity(order_name, client_name) " +
                    "VALUES (\"" + orderName + "\", \"" + clientName + "\")");
//            ResultSet resultSet = statement.executeQuery(selectOrderID);
//            while (resultSet.next()){
//                long orderId = resultSet.getLong("order_id");
//            }
            for (OrderDetailEntity o : orderDetailEntityList) {
                statement.addBatch("INSERT INTO order_detail_entity(detail_name, detail_price) " +
                        "VALUES(\"" + o.getName() + "\", " + o.getPrice() + ")");
            }
            statement.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeOrder(long orderId) {
        String deleteRow = "DELETE FROM order_entity WHERE id = " + orderId;
        try (Connection connection = connection(); Statement statement = connection.createStatement() ){
            statement.execute(deleteRow);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
