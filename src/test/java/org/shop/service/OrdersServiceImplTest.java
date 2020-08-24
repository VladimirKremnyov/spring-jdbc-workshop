package org.shop.service;

import org.junit.*;
import org.junit.runner.RunWith;
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
    public void shouldCallMethodFindAllOrdersOfOrdersRepository() {
        ordersService.findAll();
        verify(mockedOrdersRepository).findAllOrders();
        verifyNoMoreInteractions(mockedOrdersRepository);
    }

    @Test
    public void shouldCallMethodFindOrderByIDofOrdersRepositoryWithExpectedParameter() {
        long randomId = new Random().nextLong();
        ordersService.findOrderById(randomId);
        verify(mockedOrdersRepository).findOrderByID(randomId);
        verifyNoMoreInteractions(mockedOrdersRepository);
    }

    @Test
    public void shouldCallMethodAddOrderWhenSaveOrder() {
        OrderDto orderDto = mock(OrderDto.class);
        ordersService.saveOrder(orderDto);
        verify(mockedOrdersRepository).addOrder(orderDto);
        verifyNoMoreInteractions(mockedOrdersRepository);
    }

    @Test
    public void shouldCallMethodDeleteOrderWhenDeleteOrderWithExpectedParameter() {
        long randomId = new Random().nextLong();
        ordersService.deleteOrder(randomId);
        verify(mockedOrdersRepository).deleteOrder(randomId);
        verifyNoMoreInteractions(mockedOrdersRepository);
    }

    @Test
    public void shouldCallMethodUpdateOrderOfOrdersRepositoryWhenUpdateOrder() {
        OrderDto orderDto = mock(OrderDto.class);
        ordersService.updateOrder(orderDto);
        verify(mockedOrdersRepository).updateOrder(orderDto);
        verifyNoMoreInteractions(mockedOrdersRepository);
    }
}