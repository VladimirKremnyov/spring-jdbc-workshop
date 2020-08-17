package org.shop.db.entity;

import org.shop.dto.OrderDto;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="order_table")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="client", nullable = false)
    private String client;

    @JoinColumn(name = "orderID")
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetailEntity> orderDetailEntities;

    public OrderEntity() {
    }

    public OrderEntity(Long id, String name, String client,
                       List<OrderDetailEntity> orderDetailEntities) {
        this.id = id;
        this.name = name;
        this.client = client;
        this.orderDetailEntities = orderDetailEntities;
    }

    public Long getId() {
        return id;
    }

    public List<OrderDetailEntity> getOrderDetailEntities() {
        return orderDetailEntities;
    }

    public OrderDto toOrderDto() {
        return new OrderDto(id, name, client,
                orderDetailEntities.stream()
                        .map(OrderDetailEntity::toDetailDto).collect(Collectors.toList()));
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
