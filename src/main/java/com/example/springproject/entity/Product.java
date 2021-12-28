package com.example.springproject.entity;

import com.example.springproject.service.product.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private float price;
    private float quantity;

    public Product(ProductDto productDto){
        this.id = productDto.getId();
        this.name = productDto.getName();
        this.description = productDto.getDescription();
        this.imageUrl = productDto.getImageUrl();
        this.price = productDto.getPrice();
        this.quantity = productDto.getQuantity();
    }
}
