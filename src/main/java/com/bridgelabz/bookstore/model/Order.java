package com.bridgelabz.bookstore.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name="orderDetails")
public class Order
{
    @Id
    @GeneratedValue
    private int orderID;
    private LocalDate date = LocalDate.now();
    private int price;
    private int quantity;
    private String address;
    @ManyToOne
    @JoinColumn(name="User_Id")
    private UserContact userID;
    @ManyToOne
    @JoinColumn(name="book_id")
    private BookContact bookID;
    private boolean cancel;

    public Order(int orderID,int price, int quantity, String address, BookContact bookID, UserContact userID, boolean cancel) {
        this.orderID = orderID;
        this.price=price;
        this.quantity=quantity;
        this.address=address;
        this.bookID = bookID;
        this.userID=userID;
        this.cancel = cancel;
    }

    public Order() {
        super();
    }

    public Order(int price, int quantity, String address, BookContact bookID, UserContact userID, boolean cancel) {
        this.price=price;
        this.quantity=quantity;
        this.address=address;
        this.bookID = bookID;
        this.userID=userID;
        this.cancel = cancel;
    }
}
