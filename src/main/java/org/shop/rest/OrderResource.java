package org.shop.rest;

import org.shop.dto.OrderDto;
import org.shop.service.OrdersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderResource {

    private OrdersService ordersService;

    public OrderResource(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping
    public List<OrderDto> findAll() {
        return ordersService.findAll();
    }

    @GetMapping(value = "{id}")
    public OrderDto findOrderById(@PathVariable("id") long id) {
        return ordersService.findOrderById(id);
    }

    @PostMapping
    public void addOrder(@RequestBody OrderDto orderDto) {
        ordersService.saveOrder(orderDto);
    }

    @PutMapping
    public void updateOrder(@RequestBody OrderDto orderDto) {
        ordersService.updateOrder(orderDto);
    }

    @DeleteMapping(value = "{id}")
    public void deleteOrder(@PathVariable("id") long id) {
        ordersService.deleteOrder(id);
    }
}
