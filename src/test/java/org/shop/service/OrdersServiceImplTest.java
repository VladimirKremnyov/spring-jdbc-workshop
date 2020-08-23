package org.shop.service;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.shop.db.OrdersRepository;
import org.shop.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringContextTest.class})
public class OrdersServiceImplTest {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrdersRepository mockedOrdersRepository;

    @Test
    public void shouldCallOnceMethodGetOrderListOfOrdersRepository() {
        ordersService.findAll();
        verify(mockedOrdersRepository).getOrderList();
        verifyNoMoreInteractions(mockedOrdersRepository);
    }

    @Test
    public void shouldCallOnceMethodGetOrderByIDofOrdersRepositoryWithExpectedParameter() {
        long randomId = new Random().nextLong();
        ordersService.findOrderById(randomId);
        verify(mockedOrdersRepository).getOrderByID(randomId);
        verifyNoMoreInteractions(mockedOrdersRepository);
    }

    @Test
    public void shouldCallOnceMethodAddOrderToDBwhenSaveOrder() {
        OrderDto orderDto = mock(OrderDto.class);
        ordersService.saveOrder(orderDto);
        verify(mockedOrdersRepository).addOrderToDB(orderDto);
        verifyNoMoreInteractions(mockedOrdersRepository);
    }

    @Test
    public void shouldCallOnceMethodDeleteOrderFromDBwhenDeleteOrderWithExpectedParameter() {
        long randomId = new Random().nextLong();
        ordersService.deleteOrder(randomId);
        verify(mockedOrdersRepository).deleteOrderFromDB(randomId);
        verifyNoMoreInteractions(mockedOrdersRepository);
    }
