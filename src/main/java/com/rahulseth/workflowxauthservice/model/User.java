package com.rahulseth.workflowxauthservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty.")
    @Size(min = 5,max = 20)
    private String name;

    @Column(unique = true)
    @Email(message = "Email is not valid.")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must contain at least 1 uppercase, 1 lowercase, 1 number, 1 special character and be at least 8 characters long"
    )
    private String password;

    @NotNull(message = "User role cannot be null.")
    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean active = true;
}
