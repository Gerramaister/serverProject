package org.example.controller;

import org.example.model.Book;
import org.example.service.BookServiceInterface;

import javax.ejb.Remove;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Stateless
@Produces("application/JSON")
@Consumes("application/JSON")
@Path("/book")
public class BookController {

    @Inject
    private BookServiceInterface bookService;

    @GET
    public Response getAllBooks(){
        return Response.status(200).entity(bookService.getAllBooks()).build();
    };

    @GET
    @Path("/{bookId}")
    public Response getBookById(@PathParam("bookId") int bookId){
        return Response.status(Response.Status.OK).entity(bookService.getBookById(bookId)).build();
    }

    @POST
    public Response addBook(Book book){
        bookService.addBook(book);
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @DELETE
    @Path("/{bookId}")
    public Response removeBook(@PathParam("bookId") int bookId){
        bookService.removeBook(bookId);
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @PUT
    @Path("/{bookId}")
    public Response updateBook(@PathParam("bookId")int bookId, Book book){
        bookService.updateBook(book, bookId);
        return Response.status(Response.Status.ACCEPTED).entity(bookService.getBookById(bookId)).build();
    }

}
