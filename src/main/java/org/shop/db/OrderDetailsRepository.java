package org.shop.db;

import org.shop.db.entity.OrderDetailEntity;

import java.util.List;

/**
 * Here you need to specify
 * all methods which you think will be useful to complete your task
 */
public interface OrderDetailsRepository {

    List<OrderDetailEntity> getOrderDetailList(Long orderId);

    OrderDetailEntity getDetailByID(Long detailId);

    void addDetailToOrder(Long orderId, OrderDetailEntity orderDetail);

    void deleteDetailFromOrder(Long detailId);
}
