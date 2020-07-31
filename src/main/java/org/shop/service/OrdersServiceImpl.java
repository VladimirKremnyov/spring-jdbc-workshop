package org.shop.service;

import org.shop.db.OrdersRepository;
import org.shop.db.OrdersRepositoryImpl;
import org.shop.db.entity.OrderEntity;
import org.shop.dto.OrderDto;

import java.util.List;
import java.util.stream.Collectors;

public class OrdersServiceImpl implements OrdersService {

    private OrdersRepository ordersRepository = new OrdersRepositoryImpl();

    @Override
    public List<OrderDto> findAll() {
        return ordersRepository.getOrderList().stream()
                .map(OrderEntity::toOrderDto).collect(Collectors.toList());
    }

    @Override
    public OrderDto findOrderBy(long id) {
        try {
            return ordersRepository.getOrderByID(id).toOrderDto();
        } catch (NullPointerException npe) {
            System.out.print("No such order in DB! ");
            return null;
        }
    }

    @Override
    public void saveOrder(OrderDto orderDto) {
        ordersRepository.addOrderToDB(orderDto);
    }

    @Override
    public void deleteOrder(long orderId) {
        ordersRepository.deleteOrderFromDB(orderId);
    }
}
