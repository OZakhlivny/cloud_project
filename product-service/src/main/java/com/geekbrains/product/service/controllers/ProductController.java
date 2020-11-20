package com.geekbrains.product.service.controllers;


import com.geekbrains.cloud.dto.common.ProductDto;
import com.geekbrains.product.service.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getProductsByIds(@RequestParam(name = "ids") Long[] ids) {
        return productService.getProductsByIds(ids);
    }
}
