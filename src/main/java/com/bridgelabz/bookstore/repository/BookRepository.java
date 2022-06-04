package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.model.BookContact;
import com.bridgelabz.bookstore.model.UserContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<BookContact, Integer> {


    @Query(value = "SELECT * FROM book_store where bookName=:bookName", nativeQuery = true)
    List<BookContact> findByBookName(String bookName);


    @Query(value = "select * from book_store order by price", nativeQuery = true)
    List<BookContact> getSortedListOfBooksInAsc();

    @Query(value = "select * from book_store order by price desc", nativeQuery = true)
    List<BookContact> getSortedListOfBooksInDesc();

    @Query(value = "select * from book_store where author_name like :authorName%", nativeQuery = true)
    List<BookContact> findByBookAuthorName(String authorName);

}
