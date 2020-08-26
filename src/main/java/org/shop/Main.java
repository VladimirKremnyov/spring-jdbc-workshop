package org.shop;

import org.shop.db.OrderDetailRepositoryImpl;
import org.shop.db.OrderRepositoryImpl;
import org.shop.db.entity.OrderDetailEntity;
import org.shop.db.entity.OrderEntity;
import org.shop.dto.OrderDetailDto;
import org.shop.dto.OrderDto;
import org.shop.service.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/application-context.xml");
        System.out.println(context.getBean( OrderServiceImpl.class).findAll());
       // context.getBean(OrderServiceImpl.class).deleteOrder(2);

    }

}
