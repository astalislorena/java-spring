package com.example.springproject.mapper.product;

import com.example.springproject.entity.Product;
import com.example.springproject.repository.ProductRepository;
import com.example.springproject.service.product.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ProductMapperImpl implements ProductMapper {

    private final ProductRepository productRepository;

    @Override
    public ProductDto toService(Product entity) {
        return new ProductDto(entity.getId(), entity.getName(), entity.getDescription(), entity.getImageUrl(), entity.getPrice(), entity.getQuantity());
    }

    @Override
    public Product toEntity(ProductDto dto) {
        return new Product(dto.getId(), dto.getName(), dto.getDescription(), dto.getImageUrl(), dto.getPrice(), dto.getQuantity());
    }
}
