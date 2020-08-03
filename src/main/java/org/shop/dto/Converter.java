package org.shop.dto;

import org.shop.db.entity.OrderDetailEntity;
import org.shop.db.entity.OrderEntity;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    private static List<OrderDetailDto> listOrderDetailDto;
    private static List<OrderDetailEntity> listOrderDetailEntity;



    public static OrderDetailEntity DetaildtoConvertToDetailEntity(OrderDetailDto orderDetailDto) {
        return new OrderDetailEntity(
                orderDetailDto.getId(),
                orderDetailDto.getName(),
                orderDetailDto.getPrice()
        );

    }

    public static OrderEntity OrderDtoConvertToOrderEntity(OrderDto orderDto) {
        listOrderDetailEntity = new ArrayList<>();
        listOrderDetailDto = orderDto.getOrderDetails();
        for (OrderDetailDto detailDto : listOrderDetailDto
        ) {
            listOrderDetailEntity.add(new OrderDetailEntity(detailDto.getId(), detailDto.getName(), detailDto.getPrice()));
        }
        return new OrderEntity(orderDto.getId(), orderDto.getName(), orderDto.getClient(), listOrderDetailEntity);
    }

    public static OrderDto OrderEntityConvertToOrderDto(OrderEntity orderEntity) {
        listOrderDetailEntity = orderEntity.getOrderDetailEntities();
        listOrderDetailDto = new ArrayList<>();
        for (OrderDetailEntity detailEntity : listOrderDetailEntity
        ) {
            listOrderDetailDto.add(new OrderDetailDto(detailEntity.getId(), detailEntity.getName(), detailEntity.getPrice()));
        }
        return new OrderDto(orderEntity.getId(), orderEntity.getName(), orderEntity.getClient(), listOrderDetailDto);
    }
}
