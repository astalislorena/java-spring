package com.example.springproject.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "CONSUMER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consumer extends User {
    private Timestamp createdTs;

    public Consumer(Long userId) {
        this.setId(userId);
    }
}
