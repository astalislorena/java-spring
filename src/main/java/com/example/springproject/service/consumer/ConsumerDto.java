package com.example.springproject.service.consumer;

import com.example.springproject.entity.user.Consumer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class ConsumerDto {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Timestamp createdTs;

    public ConsumerDto(Consumer consumer){
        this.id = consumer.getId();
        this.email = consumer.getEmail();
        this.password = consumer.getPassword();
        this.firstName = consumer.getFirstName();
        this.lastName = consumer.getLastName();;
        this.createdTs = consumer.getCreatedTs();
    }
}
