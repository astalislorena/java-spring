package com.example.springproject.mapper.cart;

import com.example.springproject.entity.Cart;
import com.example.springproject.entity.Product;
import com.example.springproject.service.cart.CartDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartMapperImpl implements CartMapper{

    @Override
    public CartDto toService(Cart entity) {
        return new CartDto(entity.getId(), entity.getConsumer(), entity.getProducts());
    }

    @Override
    public Cart toEntity(CartDto dto) {
        List<Product> products = dto.getProducts().stream().map(Product::new).collect(Collectors.toList());
        return new Cart(dto.getId(), dto.getConsumer(),products);
    }
}
