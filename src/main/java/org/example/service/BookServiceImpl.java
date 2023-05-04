package org.example.service;

import org.example.dao.BookDaoInterface;
import org.example.model.Book;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class BookServiceImpl implements BookServiceInterface {

    @Inject
    private BookDaoInterface dao;

    @Override
    public void addBook(Book book) {
        //Here I could/should validate for example ISBN
        dao.addBook(book);
    }

    @Override
    public void removeBook(int bookId) {
        // Here I could check if book really exist before we delete
        dao.removeBook(bookId);
    }

    @Override
    public void updateBook(Book updatedBook, int bookId) {

        // Here I could validate so updated book is a valid book

        dao.updateBook(updatedBook, bookId);

    }

    @Override
    public Book getBookById(int bookId) {

        // Validate so there is no tags or SQL code

        return dao.getBookById(bookId);
    }

    @Override
    public List<Book> getAllBooks() {

        return dao.getAllBooks();
    }
}
