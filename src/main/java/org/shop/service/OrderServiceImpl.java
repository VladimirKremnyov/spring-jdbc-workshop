package org.shop.service;

import org.shop.db.OrderRepositoryImpl;
import org.shop.dto.OrderDto;

import java.util.List;

public class OrderServiceImpl implements OrdersService{
    @Override
    public List<OrderDto> findAll() {
        new OrderRepositoryImpl().findAllOrdersInDB();
        return null;
    }

    @Override
    public OrderDto findOrderBy(long id) {
        return null;
    }

    @Override
    public void saveOrder(OrderDto orderDto) {

    }

    @Override
    public void deleteOrder(long orderId) {

    }
}
