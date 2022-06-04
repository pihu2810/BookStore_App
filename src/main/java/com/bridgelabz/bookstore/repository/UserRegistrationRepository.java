package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.model.UserContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface UserRegistrationRepository extends JpaRepository<UserContact, Integer>
{
    @Query(value = "select * from book_store.userregistration_db where email = :email", nativeQuery = true)
    Optional<UserContact> findByEmailId(String email);


}
