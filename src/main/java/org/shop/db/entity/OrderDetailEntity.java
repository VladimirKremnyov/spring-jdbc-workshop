package org.shop.db.entity;


import org.shop.dto.OrderDetailDto;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_details_table")
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long detailId;

    @Column(name = "name", nullable = false)
    private String detailName;

    @Column(name = "price")
    private BigDecimal price;

    public OrderDetailEntity() {
    }

    public OrderDetailEntity(String name, BigDecimal price) {
        this.detailName = name;
        this.price = price;
    }

    public OrderDetailDto toDetailDto() {
        return new OrderDetailDto(detailId, detailName, price);
    }

    @Override
    public String toString() {
        return "OrderDetailEntity{" +
                "id=" + detailId +
                ", name='" + detailName + '\'' +
                ", price=" + price +
                '}';
    }
}
