package org.shop.db;

import org.shop.db.entity.OrderDetailEntity;
import org.shop.db.entity.OrderEntity;

import java.util.List;

/**
 * Here you need to specify
 * all methods which you think will be useful to complete your task
 */
public interface OrderDetailsRepository {

// this method returns a list of all details in the current order

    List<OrderDetailEntity> findAllDetailInCurrentOrder(long id);

// this method returns details by id

    OrderDetailEntity findDetailByIDinCurrentOrder(long id,long order_id);


// this method removes the orders detail from the database

    void deleteOrderDetailFromDB(long orderId);
}
