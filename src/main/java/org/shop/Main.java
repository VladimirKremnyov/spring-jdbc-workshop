package org.shop;

import org.shop.service.OrdersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringContext.class);
//        OrdersRepository ordersRepository = new OrdersRepositoryImpl();
//        OrdersService ordersService = new OrdersServiceImpl();
        OrdersService ordersService = context.getBean(OrdersService.class);
//        System.out.println(ordersRepository.getOrderList());
//        System.out.println(ordersService.findAll());
//        System.out.println(ordersService.findOrderBy(8));
//        List <OrderDetailDto> orderDetailDtos = Arrays.asList(new OrderDetailDto("detail1", 11.48),
//                new OrderDetailDto("detail3", 25.77));
//        OrderDto orderDto = new OrderDto("order10", "client7", orderDetailDtos);
//        ordersRepository.addOrderToDB(orderDto);
//        ordersService.saveOrder(orderDto);
//        System.out.println(ordersRepository.getOrderByID(10));
//        System.out.println(ordersService.findOrderBy(13));

//        ordersRepository.deleteOrderFromDB(12);
        ordersService.deleteOrder(13);
        System.out.println(ordersService.findOrderById(13));

//        System.out.println(ordersRepository.getOrderByID(10));
//        System.out.println(ordersRepository.getOrderList());
        System.out.println(ordersService.findAll());
    }
}
