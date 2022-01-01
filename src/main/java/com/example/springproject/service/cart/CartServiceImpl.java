package com.example.springproject.service.cart;

import com.example.springproject.entity.Cart;
import com.example.springproject.mapper.cart.CartMapper;
import com.example.springproject.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    @Override
    public CartDto getCart(Long id) {
        Cart cart = cartRepository.getById(id);
        return this.cartMapper.toService(cart);
    }
}
