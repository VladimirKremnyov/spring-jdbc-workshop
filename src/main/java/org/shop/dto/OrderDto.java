package org.shop.dto;

import org.shop.db.entity.OrderEntity;

import java.util.List;

/**
 * feel free to add any code to this class
 */
public class OrderDto {
    private long id;
    private String name;
    private String client;
    private List<OrderDetailDto> orderDetails;

    public OrderDto(OrderEntity orderEntity,List<OrderDetailDto>orderDetails) {
        this.id = orderEntity.getId();
        this.name = orderEntity.getName();
        this.client=orderEntity.getClient();
        this.orderDetails = orderDetails;
    }
}
