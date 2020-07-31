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
        List<OrderDetailEntity> orderDetailEntities=new ArrayList<>();
        orderDetailEntities.add(orderDetail1);
        orderDetailEntities.add(orderDetail2);
        OrderEntity orderEntity1=new OrderEntity(1,"Computer Parts","Ivanov",orderDetailEntities);

      //  OrderDetailRepositoryImpl orderDetailRepository=new OrderDetailRepositoryImpl();

//        System.out.println(orderDetailRepository.findAllDetailInCurrentOrder(2));
//        System.out.println(new OrderRepositoryImpl().findAllOrdersInDB());
//        System.out.println(new OrderDetailRepositoryImpl().findDetailByIDinCurrentOrder(3,2));
        System.out.println(new OrderRepositoryImpl().findOrderByID(2));
    }

}
