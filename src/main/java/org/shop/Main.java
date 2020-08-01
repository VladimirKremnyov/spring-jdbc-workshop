package org.shop;

import org.shop.db.OrderDetailRepositoryImpl;
import org.shop.db.OrderRepositoryImpl;
import org.shop.db.entity.OrderDetailEntity;
import org.shop.db.entity.OrderEntity;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderDetailEntity orderDetail1=new OrderDetailEntity(1,"Matheboard",42);
        OrderDetailEntity orderDetail2=new OrderDetailEntity(2,"Mouse",3);
        OrderDetailEntity orderDetail3=new OrderDetailEntity(3,"RAM",42);
        OrderDetailEntity orderDetail4=new OrderDetailEntity(4,"Memory",3);
        OrderDetailEntity orderDetail5=new OrderDetailEntity(5,"Matheboard",46);
        OrderDetailEntity orderDetail6=new OrderDetailEntity(6,"Mouse",5);
        OrderDetailEntity orderDetail7=new OrderDetailEntity(7,"RAM Toshiba",46);
        OrderDetailEntity orderDetail8=new OrderDetailEntity(8,"Memory Samsung",36);

        List<OrderDetailEntity> orderDetailEntities=new ArrayList<>();

        orderDetailEntities.add(orderDetail1);
        orderDetailEntities.add(orderDetail2);

        List<OrderDetailEntity> orderDetailEntities2=new ArrayList<>();
        orderDetailEntities2.add(orderDetail3);
        orderDetailEntities2.add(orderDetail4);

        OrderEntity orderEntity1=new OrderEntity(1,"Computer Parts","Ivanov",orderDetailEntities);
        OrderEntity orderEntity2=new OrderEntity(3,"Parts","Petrov",orderDetailEntities2);

        List<OrderDetailEntity> orderDetailEntities3=new ArrayList<>();
        orderDetailEntities3.add(orderDetail5);
        orderDetailEntities3.add(orderDetail6);
        orderDetailEntities3.add(orderDetail7);
        OrderEntity orderEntity3=new OrderEntity(4,"Spear Parts","LTD",orderDetailEntities3);



       OrderDetailRepositoryImpl orderDetailRepository=new OrderDetailRepositoryImpl();
//        OrderRepositoryImpl orderRepository=new OrderRepositoryImpl();
//        orderRepository.saveOrderInDB(orderEntity3);
//        orderDetailRepository.saveOrderDetailInDB(orderEntity3);
        orderDetailRepository.deleteOrderDetailFromDB(orderEntity3,1);

    }

}
