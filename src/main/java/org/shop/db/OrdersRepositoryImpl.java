package org.shop.db;

import org.shop.db.entity.OrderDetailEntity;
import org.shop.db.entity.OrderEntity;
import org.shop.dto.OrderDetailDto;
import org.shop.dto.OrderDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdersRepositoryImpl implements OrdersRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/practice_one_jdbc?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "653241";

    public static void main(String[] args) {
        OrdersRepository ordersRepository = new OrdersRepositoryImpl();
        ordersRepository.removeOrder(3);
    }

    @Override
    public List<OrderEntity> gatAllOrders() {
        String selectAllOrders = "SELECT o.id AS o_id, o.order_name AS o_name, o.client_name AS o_client_name, " +
                "od.id AS od_id, od.order_name AS od_name, od.order_price AS od_price, od.order_id AS od_order_id " +
                "FROM order_entity o LEFT JOIN order_detail_entity od ON o.id = od.order_id;";
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
    public void addOrder(OrderDto orderDto) {
        String orderID = String.valueOf(orderDto.getId());
        String orderName = orderDto.getName();
        List<OrderDetailDto> orderDetailDtos = new ArrayList<>(orderDto.getOrderDetails());
        try {
            Connection connection = connection();
            Statement statement = connection.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
//        orderDtoList.add(orderDto);
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
