package org.shop.dto;

import org.shop.db.entity.OrderDetailEntity;
import org.springframework.stereotype.Component;

/**
 * feel free to add any code to this class
 */

public class OrderDetailDto {
    private long id;
    private String name;
    private double price;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public OrderDetailDto(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDetailDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
