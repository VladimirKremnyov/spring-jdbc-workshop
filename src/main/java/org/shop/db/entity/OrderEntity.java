package org.shop.db.entity;

import org.shop.dto.OrderDto;

import java.util.List;
import java.util.stream.Collectors;

public class OrderEntity {
    private long id;
    private String name;
    private String client;
    private List<OrderDetailEntity> orderDetailEntities;

    public OrderEntity(long id, String name, String client, List<OrderDetailEntity> orderDetailEntities) {
        this.id = id;
        this.name = name;
        this.client = client;
        this.orderDetailEntities = orderDetailEntities;
    }

    public OrderEntity(String name, String client, List<OrderDetailEntity> orderDetailEntities) {
        this.name = name;
        this.client = client;
        this.orderDetailEntities = orderDetailEntities;
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

    public List<OrderDetailEntity> getOrderDetailEntities() {
        return orderDetailEntities;
    }

    public OrderDto toOrderDto() {
        return new OrderDto(id, name, client,
                orderDetailEntities.stream().map(OrderDetailEntity::toDetailDto).collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return "\nOrderEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", client='" + client + '\'' + ", orderDetailEntities:\n" +
                (orderDetailEntities.size()==0 ? "no details" : orderDetailEntities) +
                "}";
    }
}
