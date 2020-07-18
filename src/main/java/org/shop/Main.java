package org.shop;

import org.shop.db.OrdersRepository;
import org.shop.dto.OrderDetailDto;
import org.shop.dto.OrderDto;
import org.shop.service.OrdersService;
import org.shop.service.impl.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/application-context.xml");
        OrdersRepository ordersRepository = context.getBean("ordersRepository", OrdersRepository.class);
        OrdersService service=new OrderServiceImpl(ordersRepository);

//           findAll
        List<OrderDto> list=service.findAll();
        Long idTech=getID(list);
        System.out.println("FIND ALL "+list.toString());

//           findOrderBy
        System.out.println("FIND BY ID "+idTech+" "+service.findOrderById(idTech).toString());

//           saveOrder
        System.out.println("SAVE ORDER BEFORE: "+service.findAll().size());
        List<OrderDetailDto> h= new ArrayList<>();
        OrderDetailDto m=new OrderDetailDto("NameTest1",1);
        OrderDetailDto j=new OrderDetailDto("NameTest2",2);
        OrderDetailDto f=new OrderDetailDto("NameTest3",3);
        OrderDetailDto g=new OrderDetailDto("NameTest4",4.1);
        h.add(m);
        h.add(j);
        h.add(f);
        h.add(g);
        OrderDto orderDto =new OrderDto("TestName","TestClient",h);
        service.saveOrder(orderDto);
        System.out.println("SAVE ORDER AFTER: "+service.findAll().size());

//          findOrderPrice
        System.out.println("ORDER PRICE: "+service.findOrderPrice(62));

//          deleteOrder
        System.out.println("DELETE ORDER BEFORE: "+service.findAll().size());
        service.deleteOrder(idTech);
        System.out.println("DELETE ORDER AFTER: "+service.findAll().size());
        System.out.println("FIND BIG ORDERS: "+service.findBigOrders().toString());
//        System.out.println("FIND BIG ORDERS findBigOrdersAlternativeStream : "+OrderServiceImpl.findBigOrdersAlternativeStream().toString());


    }

    private static long getID(List<OrderDto> list){
        return  list.get(0).getId();
    }

}
