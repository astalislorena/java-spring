package com.example.springproject.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consumer extends User {
    private Timestamp createdTs;

    public Consumer(Long userId) {
        this.setId(userId);
    }

    public Consumer(Long id, String email, String password, String firstName, String lastName, Timestamp createdTs) {
        super(id, email, password, firstName, lastName);
        this.createdTs = createdTs;
    }
}
