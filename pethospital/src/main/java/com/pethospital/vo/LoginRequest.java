package com.pethospital.vo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

    @NotBlank(message = "userId cannot be empty")
    private String userId;

    @NotBlank(message = "Password cannot be empty")
    private String password;

}
