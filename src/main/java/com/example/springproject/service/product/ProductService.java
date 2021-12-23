package com.example.springproject.service.product;

import java.util.List;

public interface ProductService {
    ProductDto addProduct(ProductDto product);
    ProductDto getProduct(Long id);
    void deleteProduct(Long proposalDtoId);
    void updateProduct(ProductDto proposalDto);
}
