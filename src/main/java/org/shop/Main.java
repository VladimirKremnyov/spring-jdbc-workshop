package org.shop;

import org.shop.db.OrdersRepository;
import org.shop.db.OrdersRepositoryImpl;
import org.shop.dto.OrderDetailDto;
import org.shop.dto.OrderDto;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrdersRepository ordersRepository = new OrdersRepositoryImpl();

        System.out.println(ordersRepository.getOrderList());
//
//        List <OrderDetailDto> orderDetailDtos = Arrays.asList(new OrderDetailDto("detail5", 43.15),
//                new OrderDetailDto("detail7", 51.94));
//        OrderDto orderDto = new OrderDto("order9", "client6", orderDetailDtos);
//        ordersRepository.addOrderToDB(orderDto);

//        System.out.println(ordersRepository.getOrderByID(9));
//        ordersRepository.deleteOrderFromDB(5);
//        System.out.println(ordersRepository.getOrderList());
    }
}
