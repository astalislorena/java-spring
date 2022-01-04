package com.example.springproject.service.consumer;

import com.example.springproject.entity.user.Consumer;
import com.example.springproject.mapper.consumer.ConsumerMapper;
import com.example.springproject.repository.ConsumerRepository;
import com.example.springproject.service.product.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<ConsumerDto> getConsumers() {
        return consumerRepository.findAll().stream().map(product -> this.consumerMapper.toService(product)).collect(Collectors.toList());
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
            consumerRepository.save(c);
        });
    }

    @Override
    public Boolean loginConsumer(String email, String password) {
        Optional<Consumer> consumer = consumerRepository.findByEmail(email);
        if(consumer.isPresent())
        {
            if(password.equals(consumer.get().getPassword()))
                return true;
            return false;
        }
        return false;
    }
}
