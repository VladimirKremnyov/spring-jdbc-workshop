package org.shop.dto;

import org.shop.db.entity.OrderDetailEntity;

/**
 * feel free to add any code to this class
 */
public class OrderDetailDto {
    private long id;
    private String name;
    private double price;


    public OrderDetailDto(OrderDetailEntity orderDetailEntity) {
        this.id=orderDetailEntity.getId();
        this.name=orderDetailEntity.getName();
        this.price=orderDetailEntity.getPrice();
    }
}
