package org.shop.service.impl;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.shop.db.OrdersRepository;
import org.shop.db.entity.OrderEntity;
import org.shop.dto.OrderDetailDto;
import org.shop.dto.OrderDto;
import org.shop.service.OrdersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(JUnit4.class)
public class OrderServiceImplTest {

    private static long getID(List<OrderDto> list){
        return  list.get(0).getId();
    }


    ApplicationContext context =null;
    OrdersRepository ordersRepository =null;
    OrdersService service=null;
    Long id=null;
    @Before public void init(){
        context = new ClassPathXmlApplicationContext("spring/application-context.xml");
        ordersRepository = spy(context.getBean("ordersRepository", OrdersRepository.class));
        service=new OrderServiceImpl(ordersRepository);
        id=getID(service.findAll());
    }

    @Test
    public void shouldExecuteMethodFindAllInOrdersRepositoryWhenExecuteMethodFindAllInOrderServiceImpl(){
        //GIVEN
        //WHEN
        List<OrderDto> result=service.findAll();
        //THEN
//        Mockito.verify(ordersRepository,times(1)).findAll();
        assertNotNull(result);
    }


    @Test
    public void shouldReturnLongIDObjectThatExistsInBDWhenExecuteMethodFindOrderById(){
        //GIVEN
        //WHEN
        //THEN
        assertNotNull(service.findOrderById(id));
    }

    @Test
    public void shouldSaveOrderDtoWhenExecuteMethodSaveOrder(){
        //GIVEN
        OrdersRepository ordersRepository_1 = spy(context.getBean("ordersRepository", OrdersRepository.class));
        service=new OrderServiceImpl(ordersRepository_1);
        List<OrderDetailDto> h= new ArrayList<>();
        OrderDetailDto m=new OrderDetailDto("JUNIT",999);
        h.add(m);
        OrderDto orderDto =new OrderDto("JUNIT","JUNIT",h);
        OrderEntity nbv=OrderEntity.toEntity(orderDto);
        //WHEN
        service.saveOrder(orderDto);
        //THEN
        Mockito.verify(ordersRepository_1,atLeastOnce()).saveOrder(nbv);
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void shouldSDeleteOrderDtoWhenExecuteMethodDeleteOrder(){
        //GIVEN
//        Long id=getID(service.findAll());
        OrdersRepository ordersRepository_2 = spy(context.getBean("ordersRepository", OrdersRepository.class));
        service=new OrderServiceImpl(ordersRepository_2);
        OrderDto dto=service.findOrderById(id);
        OrderEntity entity=OrderEntity.toEntity(dto);
        //WHEN
        service.deleteOrder(getID(service.findAll()));
        //THEN
//        Mockito.verify(ordersRepository_2,atLeastOnce()).deleteOrder(entity);
        service.findOrderById(id);
    }





}
