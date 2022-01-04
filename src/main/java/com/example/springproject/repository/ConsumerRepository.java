package com.example.springproject.repository;

import com.example.springproject.entity.Product;
import com.example.springproject.entity.user.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
    Optional<Consumer> findById(Long id);
    Optional<Consumer> findByEmail(String email);
}