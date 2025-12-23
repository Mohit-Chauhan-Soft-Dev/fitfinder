package com.fitfinder.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CandidateRequest {

    @NotBlank(message = "Name should not be blank")
    private String name;

    @Email(message = "Invalid email format", regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")
    @NotBlank(message = "Email should not be blank")
    private String email;

    private String phone;

    @NotBlank(message = "Password should not be blank")
    @Size(min = 6, message = "Password should contain at least 6 characters")
    private String password;
}
