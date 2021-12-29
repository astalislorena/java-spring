package com.example.springproject.controller;


import com.example.springproject.service.consumer.ConsumerDto;
import com.example.springproject.service.consumer.ConsumerService;
import com.example.springproject.service.product.ProductDto;
import com.example.springproject.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumer")
@AllArgsConstructor
public class ConsumerController {

    private final ConsumerService consumerService;

    @GetMapping
    public ConsumerDto getConsumerById(@RequestParam Long id){
        return consumerService.getConsumer(id);
    }

    @PostMapping
    public ResponseEntity<?> addConsumer(@RequestBody ConsumerDto consumerDto) {
        try{
            consumerService.addConsumer(consumerDto);
        } catch (Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(consumerDto,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteConsumer(@PathVariable long id){
        try{
            consumerService.deleteConsumer(id);
        } catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateProduct( @RequestBody ConsumerDto consumerDto){
        System.out.println(consumerDto.getId());
        try{
            consumerService.updateConsumer(consumerDto);
        } catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
