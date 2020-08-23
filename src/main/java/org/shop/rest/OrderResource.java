package org.shop.rest;

import org.shop.dto.OrderDto;
import org.shop.service.OrdersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderResource {

    private OrdersService ordersService;

    @GetMapping//(produces = "application/json")
    public List<OrderDto> findAll() {
        return ordersService.findAll();
    }

    @GetMapping(value = "{id}")
    public OrderDto findOrderById(@PathVariable("id") long id) {
        return ordersService.findOrderById(id);
    }

    @PostMapping
    public void addOrder(OrderDto orderDto) {
        System.out.println(ordersService.findAll());
        ordersService.saveOrder(orderDto);
        System.out.println("Added order: " + orderDto);
        System.out.println(ordersService.findAll());
    }

    @PutMapping
    public void updateOrder(@RequestBody OrderDto orderDto) {
        System.out.println("Updated order " + orderDto);
    }

    @DeleteMapping
    public void deleteOrder(@RequestBody long id) {
        System.out.println(ordersService.findAll());
        ordersService.deleteOrder(id);
        System.out.println("Deleted order's ID " + id);
        System.out.println(ordersService.findAll());
    }
}
