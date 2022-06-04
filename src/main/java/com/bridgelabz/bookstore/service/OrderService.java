package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.Util.EmailSenderService;
import com.bridgelabz.bookstore.Util.TokenUtility;
import com.bridgelabz.bookstore.dto.OrderDTO;
import com.bridgelabz.bookstore.exception.BookStoreException;
import com.bridgelabz.bookstore.model.BookContact;
import com.bridgelabz.bookstore.model.Order;
import com.bridgelabz.bookstore.model.UserContact;
import com.bridgelabz.bookstore.repository.BookRepository;
import com.bridgelabz.bookstore.repository.OrderRepository;
import com.bridgelabz.bookstore.repository.UserRegistrationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class OrderService implements IOrderService
{
    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private UserRegistrationRepository userRepo;

    @Autowired
    EmailSenderService mailService;
    @Autowired
    TokenUtility util;

    /**
     * create a method name as insertOrder
     * Ability to save order details to repository
     * */
    @Override
    public String insertOrder(OrderDTO orderdto) {
        Optional<BookContact> book = bookRepo.findById(orderdto.getBookID());
        Optional<UserContact> user = userRepo.findById(orderdto.getUserID());
        if (book.isPresent() && user.isPresent()) {
            if (orderdto.getQuantity() <= book.get().getQuantity()) {
                int quantity = book.get().getQuantity() - orderdto.getQuantity();
                book.get().setQuantity(quantity);
                bookRepo.save(book.get());
                int totalPrice = book.get().getPrice() * orderdto.getQuantity();
                Order newOrder = new Order(totalPrice, orderdto.getQuantity(), orderdto.getAddress(), book.get(), user.get(), orderdto.isCancel());
                orderRepo.save(newOrder);
                log.info("Order record inserted successfully");
                String token = util.createToken(newOrder.getOrderID());
                mailService.sendEmail(newOrder.getUserID().getEmail(), "Test Email", "Registered SuccessFully, hii: "
                        + newOrder.getOrderID() + "Please Click here to get data-> "
                        + "http://localhost:8098/order/insert/" + token);
                log.info("Order record inserted successfully");
                return token;
            } else {
                throw new BookStoreException("Requested quantity is out of stock");
            }
        } else {
            throw new BookStoreException("Book or User doesn't exists");
        }
    }

    /**
     * create a method name as getOrderRecord by token
     * Ability to save order details to repository
     * */
    @Override
    public List<Order> getOrderRecord(String token) {
        Integer id = util.decodeToken(token);
        Optional<Order> order = orderRepo.findById(id);
        if (order.isPresent()) {
            List<Order> listOrder = orderRepo.findAll();
            log.info("Order record retrieved successfully for id " + id);
            mailService.sendEmail("priya.sports123@gmail.com", "Test Email", "Get your data with this token, hii: "
                    + order.get().getUserID().getEmail() + "Please Click here to get all data-> "
                    + "http://localhost:8098/order/getById/" + token);
            return listOrder;

        } else {
            throw new BookStoreException("Order Record doesn't exists");
        }
    }

    /**
     * create a method name as getAllOrderRecords by token
     * Ability to save order details to repository
     * */
    @Override
    public List<Order> getAllOrderRecords(String token) {
        Integer id = util.decodeToken(token);
        Optional<Order> orderData = orderRepo.findById(id);
        if (orderData.isPresent()) {
            List<Order> listOrderData = orderRepo.findAll();
            log.info("ALL order records retrieved successfully");
            mailService.sendEmail("priya.sports123@gmail.com", "Test Email", "Get your data with this token, hii: "
                    + orderData.get().getUserID().getEmail() + "Please Click here to get all data-> "
                    + "http://localhost:8098/order/getAllOrders/" + token);
            return listOrderData;
        } else {
            System.out.println("Exception ...Token not found!");
            return null;
        }
    }

    /**
     * create a method name as cancelOrder by token and user id
     * Ability to save order details to repository
     * */
    @Override
    public Order cancelOrder(String token, int userID) {
        Integer id=util.decodeToken(token);
        Optional<Order> order = orderRepo.findById(id);
        Optional<UserContact> user = userRepo.findById(userID);
        if (order.isPresent() && user.isPresent()) {
            order.get().setCancel(true);
            orderRepo.save(order.get());
            mailService.sendEmail(order.get().getUserID().getEmail(), "Test Email", "canceled order SuccessFully, hii: "
                    +order.get().getOrderID()+"Please Click here to get data of updated id-> "
                    +"http://localhost:8098/order/cancelOrder/"+token);
            return order.get();
        } else {
            throw new BookStoreException("Order Record doesn't exists");
        }
    }
    }

