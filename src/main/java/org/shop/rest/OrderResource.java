package org.shop.rest;

import org.shop.db.OrdersRepository;
import org.shop.db.OrdersRepositoryImpl;
import org.shop.db.entity.OrderEntity;
import org.shop.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderResource {

    private OrdersRepository ordersRepository = new OrdersRepositoryImpl();

    @GetMapping(produces = "application/json")
    public List<OrderEntity> findAll() {
        System.out.println("hello from findAll!");
        return ordersRepository.getOrderList();
    }

    @GetMapping(value = "{id}", produces = "application/json")
    public OrderEntity findOrderById(@PathVariable("id") long id) {
        return ordersRepository.getOrderByID(id);
    }

    @PostMapping
    public void addOrder(@RequestBody OrderDto orderDto) {
        ordersRepository.addOrderToDB(orderDto);
        System.out.println("Added order: " + orderDto);
    }

    @PutMapping
    public void updateOrder(@RequestBody OrderDto orderDto) {
        System.out.println("Updated order " + orderDto);
    }

    @DeleteMapping
    public void deleteOrder(@RequestBody long id) {
        ordersRepository.deleteOrderFromDB(id);
        System.out.println("Deleted order's ID " + id);
    }

}
