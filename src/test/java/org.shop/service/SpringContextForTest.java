package org.shop.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.shop")
//@PropertySource(value = {"classpath:application.properties"})
public class SpringContextForTest {
}
