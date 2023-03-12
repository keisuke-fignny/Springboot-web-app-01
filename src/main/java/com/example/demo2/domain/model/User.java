package com.example.demo2.domain.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
public class User {

    private int id;

    @NotBlank(message="{validation.notEmpty}")
    @Length(max=255, message="{validation.lengthError}")
    private String name;

    @NotBlank(message="{validation.notEmpty}")
    @Email(message="{validation.emailError}")
    private String mailAddress;

    private LocalDateTime createdAt;
}
