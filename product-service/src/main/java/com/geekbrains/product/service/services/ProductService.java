package com.geekbrains.product.service.services;

import com.geekbrains.cloud.dto.common.ProductDto;
import com.geekbrains.product.service.entities.Product;
import com.geekbrains.product.service.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductDto> getProductsByIds(Long[] ids) {
        List<ProductDto> products = new ArrayList<>();
        for (Long id : ids) products.add(productRepository.findById(id).map(this::convertProductToProductDto).orElseThrow());
        return products;
    }

    private ProductDto convertProductToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setPrice(product.getPrice());
        return productDto;
    };
}
