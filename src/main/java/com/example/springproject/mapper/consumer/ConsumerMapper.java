package com.example.springproject.mapper.consumer;

import com.example.springproject.entity.user.Consumer;
import com.example.springproject.service.consumer.ConsumerDto;

public interface ConsumerMapper {
    ConsumerDto toService(Consumer entity);
    Consumer toEntity(ConsumerDto dto);
}
