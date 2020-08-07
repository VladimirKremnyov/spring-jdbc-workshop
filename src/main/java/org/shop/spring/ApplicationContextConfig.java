package org.shop.spring;
import org.shop.db.OrderDetailRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.shop")
public class ApplicationContextConfig {
@Bean
    OrderDetailRepositoryImpl orderDetailRepository(){
    return new OrderDetailRepositoryImpl();
}
}
