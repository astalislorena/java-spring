package com.example.springproject.service.product;

import com.example.springproject.entity.Product;
import com.example.springproject.mapper.product.ProductMapper;
import com.example.springproject.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        Product savedProduct = this.productRepository.save(product);

        return this.productMapper.toService(savedProduct);
    }

    @Override
    public ProductDto getProduct(Long id) {
        Product product = productRepository.getById(id);
        return this.productMapper.toService(product);
    }

    @Override
    public List<ProductDto> getProducts() {
        return productRepository.findAll().stream().map(product -> this.productMapper.toService(product)).collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(Long productDtoId) {
        this.productRepository.deleteById(productDtoId);
    }

    @Override
    public void updateProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        productRepository.findById(product.getId()).ifPresent(p -> {
            p.setName(product.getName());
            p.setDescription(product.getDescription());
            p.setPrice(product.getPrice());
            p.setQuantity(product.getQuantity());
            productRepository.save(p);
        });

    }

}