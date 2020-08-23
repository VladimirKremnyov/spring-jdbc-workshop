package org.shop.service;

import org.shop.db.OrdersRepository;
import org.shop.db.OrdersRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class SpringContextTest {

    @Bean
    OrdersService ordersService() {
        return new OrdersServiceImpl(ordersRepository());
    }

    @Bean
    OrdersRepository ordersRepository() {
        return mock(OrdersRepositoryImpl.class);
    }
}

