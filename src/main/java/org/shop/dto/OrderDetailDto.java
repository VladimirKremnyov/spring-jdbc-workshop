package org.shop.dto;

import org.shop.db.entity.OrderDetailEntity;

/**
 * feel free to add any code to this class
 */
public class OrderDetailDto {
    private long id;
    private String name;
    private double price;


    public OrderDetailDto(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
