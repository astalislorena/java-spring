package com.example.springproject.service.order;

import com.example.springproject.entity.Order;
import com.example.springproject.entity.user.Consumer;
import com.example.springproject.mapper.order.OrderMapper;
import com.example.springproject.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderDto addOrder(OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        Consumer client = new Consumer(orderDto.consumerId);
        order.setConsumer(client);
        Order savedOrder = orderRepository.save(order);
        return this.orderMapper.toService(savedOrder);
    }

    @Override
    public OrderDto getOrder(Long id) {
        Order order = orderRepository.getById(id);
        return this.orderMapper.toService(order);
    }

    @Override
    public void deleteOrder(Long orderDtoId) {
        this.orderRepository.deleteById(orderDtoId);
    }
}
