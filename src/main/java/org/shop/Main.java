package org.shop;

import org.shop.db.OrderDetailsRepository;
import org.shop.db.OrderDetailsRepositoryImpl;
import org.shop.db.entity.OrderDetailEntity;
import org.shop.dto.OrderDetailDto;
import org.shop.dto.OrderDto;
import org.shop.service.OrdersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringContext.class);
        OrdersService ordersService = context.getBean(OrdersService.class);

//        List<OrderDetailDto> orderDetailDtos = Arrays.asList
//                (new OrderDetailDto("detail1", 11.48),
//                new OrderDetailDto("detail3", 25.77));
//        OrderDto orderDto = new OrderDto("order10", "client7", orderDetailDtos);
//        ordersService.saveOrder(orderDto);

//        ordersService.deleteOrder(19);
//        System.out.println(ordersService.findOrderById(15));

//        OrderDetailsRepository orderDetailsRepository = context.getBean(OrderDetailsRepository.class);
//        System.out.println(orderDetailsRepository.getDetailByID(21));

//        OrderDetailEntity orderDetail = new OrderDetailEntity("detail5", 43.15);
//        orderDetailsRepository.addDetailToOrder(3, orderDetail);
//        orderDetailsRepository.deleteDetailFromOrder(23);
//        System.out.println(ordersService.findOrderById(3));

        System.out.println(ordersService.findAll());
    }
}
