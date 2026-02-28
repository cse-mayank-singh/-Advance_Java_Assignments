package com.example.demo.model;

import jakarta.validation.constraints.*;
import lombok.Data;
@Data
public class User {
    @NotBlank(message = "Full name is required")
    @Size(min = 3, message = "Full name must be at least 3 characters")
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    @NotBlank(message = "Role is required")
    @Pattern(regexp = "ADMIN|USER", message = "Role must be ADMIN or USER")
    private String role;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be >= 18")
    @Max(value = 60, message = "Age must be <= 60")
    private Integer age;
}