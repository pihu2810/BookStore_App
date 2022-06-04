package com.bridgelabz.bookstore.model;

import lombok.Data;

import javax.persistence.*;


@Entity
public @Data class Cart
{
    @Id
    @GeneratedValue
    private int cartId;
    @ManyToOne
    @JoinColumn(name = "User_Id")
    private UserContact userID;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookContact bookID;
    private int quantity;



    public Cart(int quantity, BookContact bookID, UserContact userID) {
        super();
        this.quantity = quantity;
        this.bookID = bookID;
        this.userID = userID;
    }

    public Cart()
    {

    }
    public Cart(Integer cartId, Integer quantity, BookContact bookID, UserContact userID) {
        super();
        this.cartId = cartId;
        this.quantity = quantity;
        this.bookID = bookID;
        this.userID = userID;
    }
}
