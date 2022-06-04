package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.OrderDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.model.Order;
import com.bridgelabz.bookstore.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController
{
    @Autowired
    private IOrderService orderService;

    //Ability to call api to insert order record
    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> insertOrder(@Valid @RequestBody OrderDTO orderdto){
        String newOrder = orderService.insertOrder(orderdto);
        ResponseDTO dto = new ResponseDTO("Order placed successfully !",newOrder);
        return new ResponseEntity(dto, HttpStatus.CREATED);
    }
    //Ability to call api to get all order record by token
    @GetMapping("/retrieveAllOrders/{token}")
    public ResponseEntity<ResponseDTO> getAllOrderRecords( @PathVariable String token){
        List<Order> newOrder = orderService.getAllOrderRecords(token);
        ResponseDTO dto = new ResponseDTO("All records retrieved successfully !",newOrder);
        return new ResponseEntity(dto,HttpStatus.OK);
    }

    //Ability to call api to get order record by token
    @GetMapping("/retrieveOrder/{token}")
    public ResponseEntity<ResponseDTO> getBookRecord(@PathVariable String token){
        List<Order> newOrder = orderService.getOrderRecord(token);
        ResponseDTO dto = new ResponseDTO("Record retrieved successfully !",newOrder);
        return new ResponseEntity(dto,HttpStatus.OK);
    }
    //Ability to call api to cancel order record by token and userid
    @PutMapping ("/cancelOrder/{token}/{userID}")
    public ResponseEntity<ResponseDTO> getCancelOrder(@PathVariable String token , @PathVariable int userID){
        Order deletedOrder = orderService.cancelOrder(token,userID);
        ResponseDTO dto = new ResponseDTO("Cancel order successfully !",deletedOrder);
        return new ResponseEntity(dto,HttpStatus.OK);
    }
}
