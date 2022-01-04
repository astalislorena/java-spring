package com.example.springproject.service.product;

import java.util.List;

public interface ProductService {
    ProductDto addProduct(ProductDto product);
    ProductDto getProduct(Long id);
    List<ProductDto> getProducts();

    void deleteProduct(Long proposalDtoId);
    void updateProduct(ProductDto proposalDto);
}
