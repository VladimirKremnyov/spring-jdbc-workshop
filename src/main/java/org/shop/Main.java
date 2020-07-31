package org.shop;

import org.shop.db.OrdersRepository;
import org.shop.db.OrdersRepositoryImpl;
import org.shop.dto.OrderDetailDto;
import org.shop.dto.OrderDto;
import org.shop.service.OrdersService;
import org.shop.service.OrdersServiceImpl;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        OrdersRepository ordersRepository = new OrdersRepositoryImpl();
        OrdersService ordersService = new OrdersServiceImpl();
//        System.out.println(ordersRepository.getOrderList());
//        System.out.println(ordersService.findAll());
//        System.out.println(ordersService.findOrderBy(8));
//        List <OrderDetailDto> orderDetailDtos = Arrays.asList(new OrderDetailDto("detail1", 11.48),
//                new OrderDetailDto("detail3", 25.77));
//        OrderDto orderDto = new OrderDto("order10", "client7", orderDetailDtos);
//        ordersRepository.addOrderToDB(orderDto);
//        ordersService.saveOrder(orderDto);
//        System.out.println(ordersRepository.getOrderByID(10));
        System.out.println(ordersService.findOrderBy(12));

//        ordersRepository.deleteOrderFromDB(10);
        ordersService.deleteOrder(12);
        System.out.println(ordersService.findOrderBy(12));

//        System.out.println(ordersRepository.getOrderByID(10));
//        System.out.println(ordersRepository.getOrderList());
    }
}
