package com.example.springproject.service.cart;

import com.example.springproject.entity.Product;
import com.example.springproject.entity.user.Consumer;
import com.example.springproject.service.product.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CartDto {
    private Long id;
    private Consumer consumer;
    List<ProductDto> products;

    public CartDto(Long id,Consumer consumer, List<Product> productsList){
        this.id=id;
        this.consumer=consumer;

        products = new ArrayList<>();
        for (Product product : productsList) {
            products.add(new ProductDto(product.getId(), product.getName(), product.getDescription(), product.getImageUrl(), product.getPrice(), product.getQuantity()));
        }
    }

}
