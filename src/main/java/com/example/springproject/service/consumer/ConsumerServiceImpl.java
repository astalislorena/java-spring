package com.example.springproject.service.consumer;

import com.example.springproject.entity.user.Consumer;
import com.example.springproject.mapper.consumer.ConsumerMapper;
import com.example.springproject.repository.ConsumerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConsumerServiceImpl implements ConsumerService {
    private final ConsumerRepository consumerRepository;
    private final ConsumerMapper consumerMapper;

    @Override
    public ConsumerDto addConsumer(ConsumerDto consumerDto) {
        Consumer consumer = consumerMapper.toEntity(consumerDto);
        Consumer savedConsumer = this.consumerRepository.save(consumer);

        return this.consumerMapper.toService(savedConsumer);
    }

    @Override
    public ConsumerDto getConsumer(Long id) {
        Consumer consumer = consumerRepository.getById(id);
        return this.consumerMapper.toService(consumer);
    }

    @Override
    public ConsumerDto getCosumer(String email) {
        return null;
    }

    @Override
    public void deleteConsumer(Long consumerId) {
        this.consumerRepository.deleteById(consumerId);
    }

    @Override
    public void updateConsumer(ConsumerDto consumerDto) {
        Consumer consumer = consumerMapper.toEntity(consumerDto);
        consumerRepository.findById(consumer.getId()).ifPresent(c -> {
            c.setEmail(consumer.getEmail());
            c.setFirstName(consumer.getFirstName());
            c.setLastName(consumer.getLastName());
        });
    }
}
