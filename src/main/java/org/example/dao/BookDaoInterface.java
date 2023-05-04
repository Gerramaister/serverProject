package org.example.dao;

import org.example.model.Book;

import javax.ejb.Local;
import java.util.List;

@Local
public interface BookDaoInterface {
    void addBook(Book book);
    void removeBook(int bookId);
    void updateBook(Book updatedBook, int bookId);
    Book getBookById(int bookId);
    List<Book> getAllBooks();

}
