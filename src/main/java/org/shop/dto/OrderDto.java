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

    public OrderDto(long id, String name, String client, List<OrderDetailDto> orderDetails) {
        this.id = id;
        this.name = name;
        this.client = client;
        this.orderDetails = orderDetails;
    }
}

