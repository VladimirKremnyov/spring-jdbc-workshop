package org.shop.service;

import org.shop.db.OrdersRepository;
import org.shop.db.entity.OrderEntity;
import org.shop.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersServiceImpl implements OrdersService {
    private OrdersRepository ordersRepository;

    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public List<OrderDto> findAll() {
        return ordersRepository.findAllOrders().stream()
                .map(OrderEntity::toOrderDto).sorted(Comparator.comparing(OrderDto::getId))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto findOrderById(long id) {
        try {
            return ordersRepository.findOrderByID(id).toOrderDto();
        } catch (NullPointerException npe) {
            System.out.print("No such order in DB! ");
            return null;
        }
    }

    @Override
    public void saveOrder(OrderDto orderDto) {
        ordersRepository.addOrder(orderDto);
    }

    @Override
    public void updateOrder(OrderDto orderDto) {
        ordersRepository.updateOrder(orderDto);
    }

    @Override
    public void deleteOrder(long orderId) {
        ordersRepository.deleteOrder(orderId);
    }
}
