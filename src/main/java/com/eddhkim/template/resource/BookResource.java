package com.eddhkim.template.resource;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.eddhkim.template.entity.Book;
import com.eddhkim.template.service.BookService;

@Component
@Scope("request")
@Path("/book")
public class BookResource {
    
    @Autowired
    private BookService bookService;
    
    @GET
    @Path("/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("uuid") String uuid) {
        Book book = bookService.find(uuid);
        return Response.status(200).entity(book).build();
    }
    
    @POST
    @Path("/{uuid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(@PathParam("uuid") String uuid, Book book) {
        book.setUuid(UUID.fromString(uuid));
        bookService.add(book);
        return Response.status(200).entity("success").build();
    }
    
    @PUT
    @Path("/{uuid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("uuid") String uuid, Book book) {
        book.setUuid(UUID.fromString(uuid));
        bookService.update(book);
        return Response.status(200).entity("success").build();
    }
    
    @DELETE
    @Path("/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("uuid") String uuid) {
        bookService.remove(uuid);
        return Response.status(200).entity("success").build();
    }
}
