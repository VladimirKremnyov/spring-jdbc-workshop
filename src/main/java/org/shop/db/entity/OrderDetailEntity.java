package org.shop.db.entity;


import org.shop.dto.OrderDetailDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_details")
public class OrderDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private double price;

    public OrderDetailEntity() {

    }

    public OrderDetailEntity(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public OrderDetailEntity(long id,String name, double price) {
        this.id=id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "OrderDetailEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public OrderDetailDto toDto() {
        return new OrderDetailDto(this.id, this.name, this.price);
    }

    public OrderDetailEntity toEntity(Long id,String name,Double price) {
        return new OrderDetailEntity(id, name, price);
    }



}
