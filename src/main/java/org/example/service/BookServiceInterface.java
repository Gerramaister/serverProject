package org.example.service;

import org.example.model.Book;

import javax.ejb.Local;
import java.util.List;

@Local
public interface BookServiceInterface {

    void addBook(Book book);
    void removeBook(int bookId);
    void updateBook(Book updatedBook, int bookId);
    Book getBookById(int bookId);
    List<Book> getAllBooks();

}
