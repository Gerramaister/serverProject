package org.example.dao;

import org.example.model.Book;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@Default
public class BookDaoImpl implements BookDaoInterface {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addBook(Book book) {
        entityManager.persist(book);
    }

    @Override
    public void removeBook(int bookId) {
        Book book = getBookById(bookId);
        entityManager.remove(book);
    }

    @Override
    public void updateBook(Book updatedBook, int bookId) {
        Book book = getBookById(bookId);
        book.setAuthor(updatedBook.getAuthor());
        book.setISBN(updatedBook.getISBN());
        book.setTitle(updatedBook.getTitle());
    }

    @Override
    public Book getBookById(int bookId) {

        Query q = entityManager.createQuery("select book from Book as book where book.id = :bookId");
        q.setParameter("bookId", bookId);

        return (Book) q.getSingleResult();
    }

    @Override
    public List<Book> getAllBooks() {

        TypedQuery<Book> q = entityManager.createQuery("select book from Book as book", Book.class);
        return q.getResultList();
    }
}
