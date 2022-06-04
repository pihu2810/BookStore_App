package com.bridgelabz.bookstore.dto;

import lombok.Data;

import javax.validation.constraints.Email;


public @Data class UserLoginDTO
{

    private String email;
    private String password;

    public UserLoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
