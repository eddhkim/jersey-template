package com.eddhkim.template.service.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.eddhkim.template.dao.BookDao;
import com.eddhkim.template.entity.Book;

@RunWith(MockitoJUnitRunner.class)
public class TestBookServiceImpl {
    
    private final static String BOOK_UUID = "7a2a6860-8405-11e4-b4a9-0800200c9a66";
    
    private BookServiceImpl bookServiceImpl;
    
    @Mock
    private BookDao mockBookDao;
    
    @Before
    public void before() {
        bookServiceImpl = new BookServiceImpl(mockBookDao);
    }
    
    @After
    public void after() {
        verifyZeroInteractions(mockBookDao);
    }
    
    @Test
    public void add() {
        // INIT
        Book book = new Book();
        
        // TEST
        bookServiceImpl.add(book);
        
        // CHECK
        verify(mockBookDao).save(book);
    }
    
    @Test
    public void find() {
        // TEST
        bookServiceImpl.find(BOOK_UUID);
        
        // CHECK
        verify(mockBookDao).find(UUID.fromString(BOOK_UUID));
    }
    
    @Test
    public void update() {
        // INIT
        Book book = new Book();
        
        // TEST
        bookServiceImpl.update(book);
        
        // CHECK
        verify(mockBookDao).update(book);
    }
    
    @Test
    public void remove() {
        // TEST
        bookServiceImpl.remove(BOOK_UUID);
        
        // CHECK
        verify(mockBookDao).delete(UUID.fromString(BOOK_UUID));
    }
}
