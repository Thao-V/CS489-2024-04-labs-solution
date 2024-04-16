package cs489.lab.ads.dto;

import jakarta.validation.constraints.NotBlank;

public record UserResponse(
        Integer userId,
        String firstName,
        String lastName,
        String email
) { }
