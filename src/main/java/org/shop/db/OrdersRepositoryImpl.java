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
import java.util.stream.Collectors;

public class OrdersRepositoryImpl implements OrdersRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/hw5_jdbc?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private Connection connection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<OrderEntity> getOrderList() {
        Map<Long, OrderEntity> orderEntityMap = new HashMap<>();
        String selectAllOrdersQuery = "select order_table.id, order_table.name, order_table.client, " +
                "order_details_table.id, order_details_table.name, " +
                "order_details_table.price, order_details_table.orderID " +
                "from order_table left join order_details_table " +
                "on order_table.id=order_details_table.orderID;";
        try (Connection conn = connection(); Statement stmnt = conn.createStatement()) {
            ResultSet resultOrderSet = stmnt.executeQuery(selectAllOrdersQuery);
            while (resultOrderSet.next()) {
                long orderId = resultOrderSet.getLong("order_table.id");
                String orderName = resultOrderSet.getString("order_table.name");
                String client = resultOrderSet.getString("client");
                long detailId = resultOrderSet.getLong("order_details_table.id");
                String detailName = resultOrderSet.getString("order_details_table.name");
                double price = resultOrderSet.getDouble("price");
                OrderEntity existOrderEntity = orderEntityMap.get(orderId);
                if (existOrderEntity != null) {
                    if (detailName != null)
                        existOrderEntity.getOrderDetailEntities().add(new OrderDetailEntity(detailId, detailName, price));
                } else {
                    OrderEntity newOrderEntity = new OrderEntity(orderId, orderName, client, new ArrayList<>());
                    if (detailName != null)
                        newOrderEntity.getOrderDetailEntities().add(new OrderDetailEntity(detailId, detailName, price));
                    orderEntityMap.put(orderId, newOrderEntity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(orderEntityMap.values());
    }

    @Override
    public OrderEntity getOrderByID(long id) {
        List<OrderDetailEntity> orderDetailEntities = new ArrayList<>();
        String orderName = null;
        String client = null;
        String selectOrderByIdQuery = String.format("select order_table.id, order_table.name, order_table.client, " +
                "order_details_table.id, order_details_table.name, " +
                "order_details_table.price, order_details_table.orderID " +
                "from order_table left join order_details_table " +
                "on order_table.id=order_details_table.orderID where order_table.id = %d;", id);
        try (Connection conn = connection(); Statement stmnt = conn.createStatement()) {
            ResultSet resultSetForSoughtOrder = stmnt.executeQuery(selectOrderByIdQuery);
            while (resultSetForSoughtOrder.next()) {
                if (orderName == null || client == null) {
                    orderName = resultSetForSoughtOrder.getString("order_table.name");
                    client = resultSetForSoughtOrder.getString("client");
                }
                long detailId = resultSetForSoughtOrder.getLong("order_details_table.id");
                String detailName = resultSetForSoughtOrder.getString("order_details_table.name");
                double price = resultSetForSoughtOrder.getDouble("price");
                if (detailName != null) {
                    orderDetailEntities.add(new OrderDetailEntity(detailId, detailName, price));
                }
            }
            if (orderName != null) return new OrderEntity(id, orderName, client, orderDetailEntities);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("No such order in DB! ");
        return null;
    }

    @Override
    public void addOrderToDB(OrderDto orderDto) {
        String orderName = orderDto.getName();
        String client = orderDto.getClient();
        long orderId = 0;
        String addOrderQuery = "insert into order_table (name, client) values ('" + orderName + "', '" + client + "');";
        String selectOrderByNameQuery = String.format("select order_table.id, order_table.name " +
                "from order_table where order_table.name = '%s';", orderName);
        String preparedInsertionDetailQuery = "insert into order_details_table (name, price, orderID) values (?, ?, ?)";
        List<OrderDetailEntity> orderDetailEntities =
                orderDto.getOrderDetails().stream().map(OrderDetailDto::toDetailEntity).collect(Collectors.toList());
        try (Connection conn = connection(); Statement stmnt = conn.createStatement()) {
            stmnt.executeUpdate(addOrderQuery);
            ResultSet rs = stmnt.executeQuery(selectOrderByNameQuery);
            while (rs.next()) {
                orderId = rs.getLong("order_table.id");
            }
            PreparedStatement preparedStatement = conn.prepareStatement(preparedInsertionDetailQuery);
            int rows = 0;
            for (OrderDetailEntity orderDetailEntity : orderDetailEntities) {
                preparedStatement.setString(1, orderDetailEntity.getDetailName());
                preparedStatement.setDouble(2, orderDetailEntity.getPrice());
                preparedStatement.setLong(3, orderId);
                preparedStatement.executeUpdate();
                rows++;
            }
            System.out.println("Quantity of added order details: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteOrderFromDB(long id) {
        String deleteOrderByIdQuery = String.format("delete from order_table where order_table.id = %d;", id);
        String deleteOrderDetailsByIdQuery = String.format("delete from order_details_table where order_details_table.orderID = %d;", id);
        try (Connection conn = connection(); Statement stmnt = conn.createStatement()) {
            conn.setAutoCommit(false);
            stmnt.addBatch(deleteOrderByIdQuery);
            stmnt.addBatch(deleteOrderDetailsByIdQuery);
            System.out.println(stmnt.executeBatch());
            conn.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
