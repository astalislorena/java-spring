package com.example.springproject.service.cart;

import com.example.springproject.entity.Cart;
import com.example.springproject.service.product.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartService {
    CartDto getCart(Long id);
}
