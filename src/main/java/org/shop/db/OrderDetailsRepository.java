package org.shop.db;

import org.shop.db.entity.OrderDetailEntity;
import org.shop.db.entity.OrderEntity;

import java.util.List;

/**
 * Here you need to specify
 * all methods which you think will be useful to complete your task
 */
public interface OrderDetailsRepository {

    List<OrderDetailEntity> getOrderDetailList(long orderId);

    OrderDetailEntity getDetailByID (long orderId, long detailId);

    void addDetailToOrder (long orderId, OrderDetailEntity orderDetail);

    boolean deleteDetailFromOrder (long orderId, long detailId);
}
