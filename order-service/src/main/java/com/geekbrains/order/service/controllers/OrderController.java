package com.geekbrains.order.service.controllers;

import com.geekbrains.cloud.dto.common.OrderDto;
import com.geekbrains.order.service.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;

    @GetMapping
    public List<OrderDto> getAllOrders() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<OrderDto> getById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @PutMapping
    public void createOrder(@RequestParam Long[] ids) {
        orderService.createOrder(ids);
    }
}
