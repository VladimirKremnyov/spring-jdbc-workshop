package org.shop.dto;

import org.shop.db.entity.OrderDetailEntity;

import java.util.Objects;

/**
 * feel free to add any code to this class
 */
public class OrderDetailDto {
    private long detailDtoId;
    private String detailDtoName;
    private double detailDtoPrice;

    public OrderDetailDto(long detailDtoId, String detailDtoName, double detailDtoPrice) {
        this.detailDtoId = detailDtoId;
        this.detailDtoName = detailDtoName;
        this.detailDtoPrice = detailDtoPrice;
    }

    public OrderDetailDto(String detailDtoName, double detailDtoPrice) {
        this.detailDtoName = detailDtoName;
        this.detailDtoPrice = detailDtoPrice;
    }

    public OrderDetailEntity toDetailEntity () {
        return new OrderDetailEntity(this.detailDtoName, this.detailDtoPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailDto that = (OrderDetailDto) o;
        return detailDtoId == that.detailDtoId &&
                Double.compare(that.detailDtoPrice, detailDtoPrice) == 0 &&
                Objects.equals(detailDtoName, that.detailDtoName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detailDtoId, detailDtoName, detailDtoPrice);
    }

    @Override
    public String toString() {
        return "OrderDetailDto{" +
                "id=" + detailDtoId +
                ", name='" + detailDtoName + '\'' +
                ", price=" + detailDtoPrice +
                '}';
    }
}
