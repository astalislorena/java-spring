package com.example.springproject.mapper.product;


import com.example.springproject.entity.Product;
import com.example.springproject.service.product.ProductDto;

public interface ProductMapper {
    ProductDto toService(Product entity);

    Product toEntity(ProductDto dto);

}
