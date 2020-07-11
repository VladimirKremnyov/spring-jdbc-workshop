package org.shop.db.entity;

import org.shop.dto.OrderDetailDto;
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

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", client='" + client + '\'' +
                ", orderDetailEntities=" + orderDetailEntities +
                '}';
    }

    public OrderDto toDto(){
        List<OrderDetailDto> orderDetailDtos = null;
        if (this.orderDetailEntities != null){
            orderDetailDtos = this.orderDetailEntities.stream().map(OrderDetailEntity::toDto).collect(Collectors.toList());
        }
     return new OrderDto(this.id, this.name, orderDetailDtos );
    }
}
