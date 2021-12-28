package com.example.springproject.entity;

import com.example.springproject.entity.user.Consumer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Consumer consumer;

    @Column
    private Date orderTimestamp;

    @OneToMany
    List<Product> products;

    public Order(Long id, List<Product> products, Date orderTimestamp) {
        this.id = id;
        this.products = products;
        this.orderTimestamp = orderTimestamp;
    }
}