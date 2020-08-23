package org.shop;

import org.shop.db.OrderDetailsRepository;
import org.shop.db.OrderDetailsRepositoryImpl;
import org.shop.db.OrdersRepository;
import org.shop.db.entity.OrderDetailEntity;
import org.shop.dto.OrderDetailDto;
import org.shop.dto.OrderDto;
import org.shop.service.OrdersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/application-context.xml");
//        OrdersRepository ordersRepository = context.getBean(OrdersRepository.class);
        OrdersService ordersService = context.getBean(OrdersService.class);

//        System.out.println(ordersRepository.getOrderByID(15l));
//        System.out.println(ordersService.findOrderById(15));

//        List<OrderDetailDto> orderDetailDtos = Arrays.asList
//                (new OrderDetailDto("detail1", BigDecimal.valueOf(11.48)),
//                new OrderDetailDto("detail3", BigDecimal.valueOf(25.77)));
//        OrderDto orderDto = new OrderDto("order10", "client7", orderDetailDtos);
//        ordersRepository.addOrderToDB(orderDto);
//        ordersService.saveOrder(orderDto);

//        ordersRepository.deleteOrderFromDB(20l);
        ordersService.deleteOrder(23);

//        OrderDetailsRepository orderDetailsRepository = context.getBean(OrderDetailsRepository.class);

//        System.out.println(orderDetailsRepository.getOrderDetailList(8L));

//        System.out.println(orderDetailsRepository.getDetailByID(21L));

//        OrderDetailEntity orderDetail = new OrderDetailEntity("detail5", BigDecimal.valueOf(43.15));
//        orderDetailsRepository.addDetailToOrder(2L, orderDetail);

//        orderDetailsRepository.deleteDetailFromOrder(38L);

//        System.out.println(ordersRepository.getOrderList());
//        System.out.println(ordersRepository.getOrderByID(2L));
//        System.out.println(ordersService.findOrderById(3));
        System.out.println(ordersService.findAll());
    }
}
