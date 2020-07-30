package org.shop.dto;

import java.util.List;

/**
 * feel free to add any code to this class
 */
public class OrderDto {
    private long id;
    private String name;
    private String client;
    private List<OrderDetailDto> orderDetails;

    public OrderDto(String name, String client, List<OrderDetailDto> orderDetails) {
        this.name = name;
        this.client = client;
        this.orderDetails = orderDetails;
    }

    public String getName() {
        return name;
    }

    public String getClient() {
        return client;
    }

    public List<OrderDetailDto> getOrderDetails() {
        return orderDetails;
    }
}
