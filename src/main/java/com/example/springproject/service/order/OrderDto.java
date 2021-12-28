package com.example.springproject.service.order;

import com.example.springproject.entity.Product;
import com.example.springproject.service.product.ProductDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class OrderDto {
    Long id;
    Date orderTimestamp;
    List<ProductDto> products;
    Long consumerId;

    public OrderDto(Long id, List<Product> productsList,Date orderTimestamp, Long consumerId) {
        this.id = id;
        this.orderTimestamp = orderTimestamp;
        this.consumerId = consumerId;
        products = new ArrayList<>();
        for (Product product : productsList) {
            products.add(new ProductDto(product.getId(), product.getName(), product.getDescription(), product.getImageUrl(), product.getPrice(), product.getQuantity()));
        }
    }
}
