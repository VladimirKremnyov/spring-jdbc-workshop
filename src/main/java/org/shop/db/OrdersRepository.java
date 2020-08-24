package org.shop.db;

import org.shop.db.entity.OrderEntity;
import org.shop.dto.OrderDto;

import java.util.List;

/**
 * Here you need to specify
 * all methods which you think will be useful to complete your task
 */
public interface OrdersRepository {

    List<OrderEntity> findAllOrders();

    OrderEntity findOrderByID(Long id);

    void addOrder(OrderDto orderDto);

    void deleteOrder(Long id);

    void updateOrder(OrderDto orderDto);

}
