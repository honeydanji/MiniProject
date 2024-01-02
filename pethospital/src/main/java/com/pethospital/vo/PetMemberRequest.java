package com.pethospital.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
@Data
public class PetMemberRequest {
    @NotNull(message = "Name Cannot be null")
    @Size(min = 2, message = "Name not be less than two characters")
    private String name;

    @NotNull(message = "Nickname cannot be null")
    @Size(min = 2, message = "Nickname not be than less two characters")
    private String nickname;

    @NotNull(message = "userId cannot be null")
    private String userId;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password must be equal or grater than 8 characters")
    private String password;

    @NotNull(message = "Email cannot be null")
    @Email
    private String email;
}
