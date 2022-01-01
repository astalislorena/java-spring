package com.example.springproject.mapper.cart;


import com.example.springproject.entity.Cart;
import com.example.springproject.service.cart.CartDto;

public interface CartMapper {
    CartDto toService(Cart entity);
    Cart toEntity(CartDto dto);
}
