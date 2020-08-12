package org.shop.dto;

import java.util.List;
import java.util.Objects;

/**
 * feel free to add any code to this class
 */
public class OrderDto {
    private long id;
    private String name;
    private String client;
    private List<OrderDetailDto> orderDetailDtos;

    public OrderDto(long id, String name, String client, List<OrderDetailDto> orderDetails) {
        this.id = id;
        this.name = name;
        this.client = client;
        this.orderDetailDtos = orderDetails;
    }

    public OrderDto(String name, String client, List<OrderDetailDto> orderDetails) {
        this.name = name;
        this.client = client;
        this.orderDetailDtos = orderDetails;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClient() {
        return client;
    }

    public List<OrderDetailDto> getOrderDetailDtos() {
        return orderDetailDtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto orderDto = (OrderDto) o;
        return id == orderDto.id &&
                Objects.equals(name, orderDto.name) &&
                Objects.equals(client, orderDto.client) &&
                Objects.equals(orderDetailDtos, orderDto.orderDetailDtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, client, orderDetailDtos);
    }

    @Override
    public String toString() {
        return "\nOrderDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", client='" + client + '\'' + ", orderDetailDtos:\n" +
                (orderDetailDtos.size()==0 ? "no details" : orderDetailDtos) +
                "}";
    }
}
