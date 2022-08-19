package com.blog.server.domain.user.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDTO {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
