package com.github.seseque.dockerusers.users;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserReq {
    @NotBlank(message = "Name is mandatory")
    String username;
}
