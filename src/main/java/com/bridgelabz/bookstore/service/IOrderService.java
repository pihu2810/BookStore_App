package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.CartDTO;
import com.bridgelabz.bookstore.dto.OrderDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.model.Cart;
import com.bridgelabz.bookstore.model.Order;

import java.util.List;

public interface IOrderService
{
    String insertOrder(OrderDTO orderdto);
    List<Order> getOrderRecord (String token);
    List<Order> getAllOrderRecords(String token);

    Order cancelOrder(String token,int userID);

//    List<Order> getAllOrderRecords();
//    Order getOrderRecord(int id);
//
//    Order cancelOrder(int id);
//
//    Order deleteOrderRecord(int id);
//
//    Order updateOrderRecord(int id, OrderDTO dto);
}
