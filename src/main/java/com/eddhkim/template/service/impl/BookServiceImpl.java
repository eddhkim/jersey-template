package com.eddhkim.template.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eddhkim.template.dao.BookDao;
import com.eddhkim.template.entity.Book;
import com.eddhkim.template.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {
    
    private final BookDao bookDao;
    
    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    
    @Override
    public void add(Book book) {
        bookDao.save(book);
    }
    
    @Override
    public Book find(String uuid) {
        return bookDao.find(UUID.fromString(uuid));
    }
    
    @Override
    public void update(Book book) {
        bookDao.update(book);
    }
    
    @Override
    public void remove(String uuid) {
        bookDao.delete(UUID.fromString(uuid));
    }
}
