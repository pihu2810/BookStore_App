package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.CartDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.model.Cart;

import java.util.List;

public interface ICartService
{
    String insertItems(CartDTO cartdto);
    List<Cart> getCartDetails(String token);
    Cart getCartDetailsById(String token);
    void deleteCartItemById(String token);
    Cart updateRecordById(String token, CartDTO cartDTO);
}
