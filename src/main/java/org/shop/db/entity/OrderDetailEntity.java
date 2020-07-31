package org.shop.db.entity;


import org.shop.dto.OrderDetailDto;

public class OrderDetailEntity {
    private long detailId;
    private String detailName;
    private double price;

    public OrderDetailEntity(long id, String name, double price) {
        this.detailId = id;
        this.detailName = name;
        this.price = price;
    }

    public OrderDetailEntity(String name, double price) {
        this.detailName = name;
        this.price = price;
    }

    public long getDetailId() {
        return detailId;
    }

    public String getDetailName() {
        return detailName;
    }

    public double getPrice() {
        return price;
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
