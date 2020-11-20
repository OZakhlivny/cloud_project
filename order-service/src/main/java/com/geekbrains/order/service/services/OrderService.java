package com.geekbrains.order.service.services;


import com.geekbrains.cloud.dto.common.OrderDto;
import com.geekbrains.cloud.dto.common.OrderItemDto;
import com.geekbrains.cloud.dto.common.ProductDto;
import com.geekbrains.order.service.controllers.GetProductController;
import com.geekbrains.order.service.entities.Order;
import com.geekbrains.order.service.entities.OrderItem;
import com.geekbrains.order.service.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final GetProductController getProductController;

    public List<OrderDto> findAll() {
        return orderRepository.findAll().stream().map(this::convertOrderToOrderDto).collect(Collectors.toList());
    }

    public Optional<OrderDto> findById(Long id) {
        return orderRepository.findById(id).map(this::convertOrderToOrderDto);
    }

    public OrderDto convertOrderToOrderDto(Order order){
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setPrice(order.getPrice());
        orderDto.setAddress(order.getAddress());
        orderDto.setItems(order.getItems().stream().map(this::convertOrderItemToOrderItemDto).collect(Collectors.toList()));
        return orderDto;
    }

    public OrderItemDto convertOrderItemToOrderItemDto(OrderItem orderItem){
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setId(orderItem.getId());
        orderItemDto.setProductId(orderItem.getProductId());
        orderItemDto.setPrice(orderItem.getPrice());
        orderItemDto.setPricePerProduct(orderItem.getPricePerProduct());
        orderItemDto.setQuantity(orderItem.getQuantity());
        return orderItemDto;
    }

    public void createOrder(Long[] ids) {
        int totalPrice = 0;
        List<ProductDto> productDtoList = getProductController.getProductsByIds(ids);
        List<OrderItem> orderItems = productDtoList.stream().map(OrderItem::new).collect(Collectors.toList());
        for(OrderItem oi : orderItems) totalPrice += oi.getPrice();
        Order newOrder = new Order(orderItems, totalPrice);
        orderRepository.save(newOrder);
    }
}
