package org.shop.service;

import org.shop.db.OrdersRepository;
import org.shop.db.OrdersRepositoryImpl;
import org.shop.db.entity.OrderEntity;
import org.shop.dto.OrderDto;

import java.util.ArrayList;
import java.util.List;

public class OrdersServiceImpl implements OrdersService {

    private OrdersRepository ordersRepository = new OrdersRepositoryImpl();

    @Override
    public List<OrderDto> findAll() {
        return new ArrayList<>();
    }

    @Override
    public OrderDto findOrderBy(long id) {
        return null;
    }

    @Override
    public void saveOrder(OrderEntity orderEntity) {
        ordersRepository.addOrder(orderEntity);
    }

    @Override
    public void deleteOrder(long orderId) {
        ordersRepository.removeOrder(orderId);
    }
}
