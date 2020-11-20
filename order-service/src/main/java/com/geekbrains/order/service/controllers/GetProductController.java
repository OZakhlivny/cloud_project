package com.geekbrains.order.service.controllers;

import com.geekbrains.cloud.dto.common.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("product-service")
public interface GetProductController {
    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/products")
    List<ProductDto> getProductsByIds(@RequestParam Long[] ids);
}
