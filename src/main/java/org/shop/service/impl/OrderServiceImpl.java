package org.shop.service.impl;

import org.shop.db.OrdersRepository;
import org.shop.db.entity.OrderEntity;
import org.shop.dto.OrderDto;
import org.shop.service.OrdersService;

import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrdersService {

    private  static OrdersRepository ordersRepository;

    public OrderServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public List<OrderDto> findAll() {
        return ordersRepository.findAll().stream().map(OrderEntity::toDto).collect(Collectors.toList());
    }

    @Override
    public OrderDto findOrderById(long id) {
        return ordersRepository.findById(id).toDto();
    }

    @Override
    public void saveOrder(OrderDto orderDto) {
        ordersRepository.saveOrder(new OrderEntity().toEntity(orderDto));
    }

    @Override
    public void deleteOrder(long orderId) {
        ordersRepository.deleteOrder(ordersRepository.findById(orderId));
    }

    @Override
    public double findOrderPrice(long orderId) {
        OrderDto dto=ordersRepository.findById(orderId).toDto();
        return dto.getOrderDetails().stream().map(element -> element.getPrice()).reduce((double) 0,Double::sum);
    }

    @Override
    public List<OrderDto> findBigOrders() {
        return ordersRepository.findAll().stream().map(OrderEntity::toDto)
                .filter(element -> element.getOrderDetails().size()>3)
                .collect(Collectors.toList());
    }





}
