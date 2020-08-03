package org.shop;

import org.shop.db.OrderDetailRepositoryImpl;
import org.shop.db.OrderRepositoryImpl;
import org.shop.db.entity.OrderDetailEntity;
import org.shop.db.entity.OrderEntity;
import org.shop.dto.OrderDetailDto;
import org.shop.dto.OrderDto;
import org.shop.service.OrderServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        OrderDetailEntity orderDetail1 = new OrderDetailEntity(1, "Motheboard", 42);
//        OrderDetailEntity orderDetail2 = new OrderDetailEntity(2, "Mouse", 3);
//        OrderDetailEntity orderDetail3 = new OrderDetailEntity(3, "RAM", 42);
//        OrderDetailEntity orderDetail4 = new OrderDetailEntity(4, "Memory", 3);
//        OrderDetailEntity orderDetail5 = new OrderDetailEntity(5, "Motheboard", 46);
//        OrderDetailEntity orderDetail6 = new OrderDetailEntity(6, "Mouse", 5);
//        OrderDetailEntity orderDetail7 = new OrderDetailEntity(7, "RAM Toshiba", 46);
//        OrderDetailEntity orderDetail8 = new OrderDetailEntity(8, "Memory Samsung", 36);
//
//        OrderDetailEntity orderDetail9 = new OrderDetailEntity(1, "Motheboard Asus", 45);
//        OrderDetailEntity orderDetail10 = new OrderDetailEntity(2, "Mouse Logitech", 4);
//        OrderDetailEntity orderDetail11 = new OrderDetailEntity(3, "RAM Samsung", 45);
//        OrderDetailEntity orderDetail12 = new OrderDetailEntity(4, "Memory Hitachi", 48);
//        OrderDetailEntity orderDetail13 = new OrderDetailEntity(5, "Motheboard ", 46);
//        OrderDetailEntity orderDetail14 = new OrderDetailEntity(6, "Mouse Apaccer", 5);
//        OrderDetailEntity orderDetail15 = new OrderDetailEntity(7, "RAM Liteon", 46);

//        OrderDetailDto orderDetailDto1 = new OrderDetailDto(1, "Motheboard Asus", 44);
//        OrderDetailDto orderDetailDto2 = new OrderDetailDto(2, "Motheboard GIGABATY", 45);
//
//        List<OrderDetailDto> orderDetailDtos = new ArrayList<>();
//        orderDetailDtos.add(orderDetailDto1);
//        orderDetailDtos.add(orderDetailDto2);
//        OrderDto orderDto = new OrderDto(3, "Test", "Test", orderDetailDtos);
//        new OrderServiceImpl().saveOrder(orderDto);

//        List<OrderDetailEntity> listOfDetail1 = new ArrayList<>();
//        listOfDetail1.add(orderDetail1);
//        listOfDetail1.add(orderDetail2);
//        listOfDetail1.add(orderDetail3);
//        listOfDetail1.add(orderDetail4);
//        listOfDetail1.add(orderDetail5);
//        listOfDetail1.add(orderDetail6);
//        listOfDetail1.add(orderDetail7);
//        listOfDetail1.add(orderDetail8);

//        List<OrderDetailEntity> listOfDetail2 = new ArrayList<>();
//
//        listOfDetail2.add(orderDetail9);
//        listOfDetail2.add(orderDetail10);
//        listOfDetail2.add(orderDetail11);
//        listOfDetail2.add(orderDetail12);
//        listOfDetail2.add(orderDetail13);
//
//        List<OrderDetailEntity> listOfDetail3 = new ArrayList<>();
//
//        listOfDetail3.add(orderDetail14);
//        listOfDetail3.add(orderDetail15);
//
//
//        OrderEntity orderEntity1 = new OrderEntity(1, "ltd Technosvit", "Petrov", listOfDetail1);
//        OrderEntity orderEntity2 = new OrderEntity(2, "ltd Serena", "Pavlov", listOfDetail2);
//        OrderEntity orderEntity3 = new OrderEntity(3, "ltd Sovinteh", "Barabanov", listOfDetail3);
//
//        OrderRepositoryImpl orderRepository = new OrderRepositoryImpl();
//        orderRepository.saveOrderInDB(orderEntity1);
        OrderServiceImpl orderService=new OrderServiceImpl();
        System.out.println(orderService.findAll());

    }

}
