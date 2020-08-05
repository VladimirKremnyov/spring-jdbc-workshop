package org.shop.service;

import org.shop.db.OrderRepositoryImpl;
import org.shop.db.entity.OrderEntity;
import org.shop.dto.Converter;
import org.shop.dto.OrderDto;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrdersService {

    private OrderRepositoryImpl orderRepository;

    public OrderServiceImpl(OrderRepositoryImpl orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderDto> findAll() {
        List<OrderEntity> orderEntityList = orderRepository.findAllOrdersInDB();
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (OrderEntity order : orderEntityList
        ) {
            orderDtoList.add(Converter.OrderEntityConvertToOrderDto(order));

        }
        return orderDtoList;
    }

    @Override
    public OrderDto findOrderBy(long id) {
        return null;
    }

    @Override
    public void saveOrder(OrderDto orderDto) {
        orderRepository.saveOrderInDB(Converter.OrderDtoConvertToOrderEntity(orderDto));

    }

    @Override
    public void deleteOrder(long orderId) {
        orderRepository.deleteOrderFromDB(orderId);

    }
}
