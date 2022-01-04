package com.example.springproject.service.consumer;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ConsumerService {
    ConsumerDto addConsumer(ConsumerDto consumer);
    ConsumerDto getConsumer(Long id);
    ConsumerDto getCosumer(String email);

    List<ConsumerDto> getConsumers();

    void deleteConsumer(Long consumerId);
    void updateConsumer(ConsumerDto consumerDto);

    Boolean loginConsumer(String email, String password);
}
