package com.example.springproject.service.consumer;

public interface ConsumerService {
    ConsumerDto addConsumer(ConsumerDto consumer);
    ConsumerDto getConsumer(Long id);
    ConsumerDto getCosumer(String email);
    void deleteConsumer(Long consumerId);
    void updateConsumer(ConsumerDto consumerDto);
}
