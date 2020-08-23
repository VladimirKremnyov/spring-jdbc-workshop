package org.shop.dto;

import org.shop.db.entity.OrderDetailEntity;
import org.shop.db.entity.OrderEntity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * feel free to add any code to this class
 */
public class OrderDto {
    private Long id;
    private String name;
    private String client;
    private List<OrderDetailDto> orderDetailDtos;

    public OrderDto(String name, String client, List<OrderDetailDto> orderDetailDtos) {
        this.name = name;
        this.client = client;
        this.orderDetailDtos = orderDetailDtos;
    }

    public OrderDto(Long id, String name, String client, List<OrderDetailDto> orderDetails) {
        this.id = id;
        this.name = name;
        this.client = client;
        this.orderDetailDtos = orderDetails;
    }

    public Long getId() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setOrderDetailDtos(List<OrderDetailDto> orderDetailDtos) {
        this.orderDetailDtos = orderDetailDtos;
    }

    public OrderEntity toOrderEntity() {
        return new OrderEntity(id, name, client,
                orderDetailDtos.stream()
                        .map(OrderDetailDto::toDetailEntity).collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto orderDto = (OrderDto) o;
        return id.equals(orderDto.id) &&
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
                (orderDetailDtos.size() == 0 ? "no details" : orderDetailDtos) +
                "}";
    }
}
