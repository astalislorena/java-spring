package com.example.springproject.mapper.order;

import com.example.springproject.entity.Order;
import com.example.springproject.entity.Product;
import com.example.springproject.service.order.OrderDto;
import com.example.springproject.service.product.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderMapperImpl implements OrderMapper{
    @Override
    public OrderDto toService(Order entity) {
        return new OrderDto(entity.getId(),entity.getProducts(),entity.getOrderTimestamp(),entity.getConsumer().getId());
    }

    @Override
    public Order toEntity(OrderDto dto) {
        List<Product> products = dto.getProducts().stream().map(Product::new).collect(Collectors.toList());
        return new Order(dto.getId(), products, dto.getOrderTimestamp());
    }
}
