package org.shop.dto;

import java.util.List;

/**
 * feel free to add any code to this class
 */
public class OrderDto {
    private long id;
    private String name;
    private List<OrderDetailDto> orderDetails;

    public OrderDto(long id, String name, List<OrderDetailDto> orderDetails) {
        this.id = id;
        this.name = name;
        this.orderDetails = orderDetails;
    }
}
