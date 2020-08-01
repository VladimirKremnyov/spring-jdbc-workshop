package org.shop.db;

import org.shop.db.entity.OrderEntity;
import org.shop.dto.OrderDto;

import java.util.List;

/**
 * Here you need to specify
 * all methods which you think will be useful to complete your task
 */
public interface OrdersRepository {


// this method returns a list of all orders

    List<OrderEntity> findAllOrdersInDB();



// this method returns the order by its ID

    OrderEntity findOrderByID(long id);

// this method saves the order to the database

    void saveOrderInDB(OrderEntity orderEntity);

// this method removes the order from the database

    void deleteOrderFromDB(long orderId);

}
