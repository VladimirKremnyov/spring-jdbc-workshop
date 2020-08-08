package org.shop.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.shop.SpringContext;
import org.shop.db.OrdersRepository;
import org.shop.db.entity.OrderDetailEntity;
import org.shop.db.entity.OrderEntity;
import org.shop.dto.OrderDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {SpringContextForTest.class})
//@RunWith(SpringRunner.class)
public class OrdersServiceImplTest {

    public static final List<OrderDetailEntity> ORDER_DETAIL_ENTITIES = Arrays.asList(
            new OrderDetailEntity(1, "detail1", 11.48),
            new OrderDetailEntity(2, "detail3", 25.77));
    public static final OrderEntity ORDER_ENTITY =
            new OrderEntity("order9", "client7", ORDER_DETAIL_ENTITIES);

    private OrdersRepository mockedOrdersRepository;
    private OrdersService ordersService;

//    ApplicationContext context = new AnnotationConfigApplicationContext(SpringContext.class);

//@InjectMocks
//    private OrdersRepository mockedOrdersRepository;

    @Before
    public void init() {
//        mockedOrdersRepository = context.getBean(OrdersRepository.class);
        mockedOrdersRepository = mock(OrdersRepository.class);
        ordersService = new OrdersServiceImpl (mockedOrdersRepository);
    }

    @Test
    public void shouldCallOnceMethodGetOrderListOfOrdersRepository() {
        ordersService.findAll();
        verify(mockedOrdersRepository).getOrderList();
        verifyNoMoreInteractions(mockedOrdersRepository);
    }

    @Test
    public void shouldReturnExpectedOrderDtoList() {
        //GIVEN
        List<OrderEntity> orderEntities = Arrays.asList(ORDER_ENTITY);
        when(mockedOrdersRepository.getOrderList()).thenReturn(orderEntities);
        List<OrderDto> expectedOrderDtos = orderEntities.stream().map(OrderEntity::toOrderDto).collect(Collectors.toList());
        //WHEN
        List<OrderDto> actualOrderDtos = ordersService.findAll();
        //THEN
        assertEquals(expectedOrderDtos, actualOrderDtos);
        verify(mockedOrdersRepository).getOrderList();
        verifyNoMoreInteractions(mockedOrdersRepository);
    }

    @Test
    public void shouldCallOnceMethodGetOrderByIDofOrdersRepositoryAndReturnExpectedOrderDto() {
        //GIVEN
        when(mockedOrdersRepository.getOrderByID(0)).thenReturn(ORDER_ENTITY);
        OrderDto expectedOrderDto = ORDER_ENTITY.toOrderDto();
        //WHEN
        OrderDto actualOrderDto = ordersService.findOrderById(0);
        //THEN
        assertEquals(expectedOrderDto, actualOrderDto);
        verify(mockedOrdersRepository).getOrderByID(0);
        verifyNoMoreInteractions(mockedOrdersRepository);
    }

    @Test
    public void shouldCallOnceMethodAddOrderToDBofOrdersRepository() {
        OrderDto addedOrderDto = ORDER_ENTITY.toOrderDto();
        ordersService.saveOrder(addedOrderDto);
        verify(mockedOrdersRepository).addOrderToDB(addedOrderDto);
        verifyNoMoreInteractions(mockedOrdersRepository);
    }

    @Test
    public void shouldCallOnceMethodDeleteOrderFromDBofOrdersRepository() {
        long deletedOrderId = 0;
        ordersService.deleteOrder(deletedOrderId);
        verify(mockedOrdersRepository).deleteOrderFromDB(deletedOrderId);
        verifyNoMoreInteractions(mockedOrdersRepository);
    }
}