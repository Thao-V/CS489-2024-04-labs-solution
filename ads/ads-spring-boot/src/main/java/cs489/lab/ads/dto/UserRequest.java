package cs489.lab.ads.dto;

import jakarta.validation.constraints.NotBlank;

public record UserRequest (
        String firstName,
        String lastName,
        @NotBlank(message = "Email should be blank.")
        String email,
        @NotBlank(message = "Password should be blank.")
        String password,
        String phoneNumber,
        String specialization,
        String dob,
        String officePhoneNumber
        ){ }
