package com.geekbrains.cloud.dto.common;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItemDto {
    private Long id;
    private Long productId;
    private int quantity;
    private int pricePerProduct;
    private int price;
}
