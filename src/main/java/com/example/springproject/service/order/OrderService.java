package com.example.springproject.service.order;

import com.example.springproject.service.product.ProductDto;

public interface OrderService {
    OrderDto addOrder(OrderDto order);
    OrderDto getOrder(Long id);
    void deleteOrder(Long orderDtoId);
}
