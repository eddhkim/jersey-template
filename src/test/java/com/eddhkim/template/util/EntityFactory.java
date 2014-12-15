package com.eddhkim.template.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.eddhkim.template.entity.Book;

@Component
public class EntityFactory {
    
    public Book createBook(UUID uuid, String title, String content) {
        Book book = new Book();
        book.setUuid(uuid);
        book.setTitle(title);
        book.setContent(content);
        return book;
    }
}
