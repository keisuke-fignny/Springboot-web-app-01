package com.example.demo2.domain.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class User {
    private int id;
    private String name;
    private String mailAddress;
    private LocalDateTime createdAt;
}
