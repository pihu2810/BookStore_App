package com.bridgelabz.bookstore.dto;

import lombok.Data;

@Data
public class ForgotPWDDTO
{
    public String email;

    public ForgotPWDDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
