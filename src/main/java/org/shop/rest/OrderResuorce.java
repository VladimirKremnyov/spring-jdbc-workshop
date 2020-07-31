package org.shop.rest;


import org.shop.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderResuorce {


    public class OrderResource {

        @GetMapping(produces = "application/json")
        public List<OrderDto> findAll() {
            return null;
        }

        @PostMapping
        public void createOrderDto(@RequestBody OrderDto orderDto) {
            System.out.println("Created order: " + orderDto);
        }

        @PutMapping
        public void updateOrderDto(@RequestBody OrderDto orderDto) {
            System.out.println("Updated order " + orderDto);
        }

        @DeleteMapping
        public void deleteOrderDto(@RequestBody OrderDto orderDto) {
            System.out.println("Deleted order " + orderDto);
        }

    }
}
