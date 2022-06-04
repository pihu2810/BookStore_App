package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.BookDTO;
import com.bridgelabz.bookstore.model.BookContact;

import java.util.List;

public interface IBookService
{
    String createBook(BookDTO bookDTO);
    List<BookContact> getAllBookData(String token);
    BookContact getBookDataById(String token);
    List<BookContact> getBookByName(String bookName);
    List<BookContact> sortedListOfBooksInAscendingOrder();
    List<BookContact> sortedListOfBooksInDescendingOrder();
    String deleteRecordById(String token);
    BookContact updateRecordById(String token,BookDTO bookDTO);
    List<BookContact> getBookByAuthorName(String authorName);

    BookContact updataBooksByQuantity(String token, int quantity);

}
