package com.example.springproject.controller;

import com.example.springproject.service.order.OrderDto;
import com.example.springproject.service.order.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public OrderDto getOrderById(@RequestParam Long id){
        return orderService.getOrder(id);
    }

    @PostMapping
    public ResponseEntity<?> addOrder(@RequestBody OrderDto orderDto) {
        System.out.println(orderDto.getProducts());
        try{
            orderService.addOrder(orderDto);
        } catch (Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(orderDto,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable long id){
        try{
            orderService.deleteOrder(id);
        } catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
