package com.example.springproject.mapper.order;

import com.example.springproject.entity.Order;
import com.example.springproject.service.order.OrderDto;
import com.example.springproject.service.product.ProductDto;

public interface OrderMapper {
    OrderDto toService(Order entity);
    Order toEntity(OrderDto dto);
}
