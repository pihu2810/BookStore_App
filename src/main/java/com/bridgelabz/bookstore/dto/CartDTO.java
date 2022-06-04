package com.bridgelabz.bookstore.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

public @Data class CartDTO
{
    private int userID;
    private int bookID;
    @NotNull(message = "Book quantity need to be added")
    private int quantity;

}
