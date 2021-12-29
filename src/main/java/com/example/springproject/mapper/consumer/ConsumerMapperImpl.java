package com.example.springproject.mapper.consumer;

import com.example.springproject.entity.user.Consumer;
import com.example.springproject.service.consumer.ConsumerDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConsumerMapperImpl implements ConsumerMapper {

    @Override
    public ConsumerDto toService(Consumer entity) {
        return new ConsumerDto(entity);
    }

    @Override
    public Consumer toEntity(ConsumerDto dto) {
        return new Consumer(dto.getId(), dto.getEmail(), dto.getPassword(), dto.getFirstName(), dto.getLastName(), dto.getCreatedTs());
    }
}
