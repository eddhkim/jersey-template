package com.eddhkim.template.dao.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.eddhkim.template.dao.BookDao;
import com.eddhkim.template.entity.Book;
import com.eddhkim.template.exception.DataAccessException;

@Repository("bookDaoImpl")
public class BookDaoImpl implements BookDao {
    
    private Map<UUID, Book> bookStorage;
    
    public BookDaoImpl() {
        bookStorage = new HashMap<UUID, Book>();
    }
    
    @Override
    public void save(Book book) {
        bookStorage.put(book.getUuid(), book);
    }
    
    @Override
    public Book find(UUID uuid) {
        Book book = bookStorage.get(uuid);
        if (book == null) {
            throw new DataAccessException();
        }
        return book;
    }
    
    @Override
    public void update(Book book) {
        // find the book first
        Book bookToUpdate = find(book.getUuid());
        
        // update title
        String newTitle = book.getTitle();
        if (newTitle != null) {
            bookToUpdate.setTitle(newTitle);
        }
        
        // update content
        String newContent = book.getContent();
        if (newContent != null) {
            bookToUpdate.setContent(newContent);
        }
    }
    
    @Override
    public void delete(UUID uuid) {
        bookStorage.remove(uuid);
    }
}
