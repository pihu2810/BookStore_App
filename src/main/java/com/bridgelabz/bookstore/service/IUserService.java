package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.UserLoginDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.dto.UserDTO;
import com.bridgelabz.bookstore.model.UserContact;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    String addUser(UserDTO userDTO);

    List<UserContact> getAllUsers();

    ResponseDTO loginUser(UserLoginDTO userLoginDTO);

    String forgotPassword(String email, String password);

    Object getUserByEmailId(String email);

    List<UserContact> getAllUserDataByToken(String token);

    UserContact updateRecordById(int contactId, UserDTO userDTO);
    ResponseEntity<ResponseDTO> verify(String token);

//    String addUser(UserDTO userDTO);
//
//    List<UserContact> getAllUsers();
//
//    // Object getUserByToken(String token);
//
//    String forgotPassword(String email, String password);
//
//    Optional<UserContact> getByEmailId(String emailid);
//
//    ResponseDTO loginUser(UserLoginDTO userLoginDTO);
//
//    UserContact updateRecordById(int contactId, UserDTO userDTO);
//    ResponseEntity<ResponseDTO> verify(String token);

}
