package com.eddhkim.template.dao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.eddhkim.template.entity.Book;
import com.eddhkim.template.exception.DataAccessException;
import com.eddhkim.template.util.EntityFactory;

@ContextConfiguration(locations = "/applicationContextTest.xml")
public class ITBookDao extends AbstractJUnit4SpringContextTests {
    
    private static final String TITLE = "Book Title";
    private static final String CONTENT1 = "Book content. Book content.";
    private static final String CONTENT2 = "Book content. Book content. Book content. Book content.";
    
    @Autowired
    private EntityFactory entityFactory;
    @Autowired
    private BookDao bookDao;
    
    @Test
    public void save() {
        // INIT
        UUID uuid = UUID.randomUUID();
        Book book = entityFactory.createBook(uuid, TITLE, CONTENT1);
        
        // TEST
        bookDao.save(book);
        
        // CHECK
        Book bookSaved = bookDao.find(uuid);
        assertThat(bookSaved.getUuid(), is(uuid));
        assertThat(bookSaved.getTitle(), is(TITLE));
        assertThat(bookSaved.getContent(), is(CONTENT1));
    }
    
    @Test
    public void find() {
        // INIT
        UUID uuid = UUID.randomUUID();
        Book book = entityFactory.createBook(uuid, TITLE, CONTENT1);
        bookDao.save(book);
        
        // TEST
        Book bookFound = bookDao.find(uuid);
        
        // CHECK
        assertThat(bookFound.getUuid(), is(uuid));
        assertThat(bookFound.getTitle(), is(TITLE));
        assertThat(bookFound.getContent(), is(CONTENT1));
    }
    
    @Test
    public void update() {
        // INIT
        UUID uuid = UUID.randomUUID();
        Book book = entityFactory.createBook(uuid, TITLE, CONTENT1);
        bookDao.save(book);
        
        Book updateBook = entityFactory.createBook(uuid, null, CONTENT2);
        
        // TEST
        bookDao.update(updateBook);
        
        // CHECK
        Book bookSaved = bookDao.find(uuid);
        assertThat(bookSaved.getUuid(), is(uuid));
        assertThat(bookSaved.getTitle(), is(TITLE));
        assertThat(bookSaved.getContent(), is(CONTENT2));
    }
    
    @Test (expected = DataAccessException.class)
    public void delete() {
        // INIT
        UUID uuid = UUID.randomUUID();
        Book book = entityFactory.createBook(uuid, TITLE, CONTENT1);
        bookDao.save(book);
        
        // TEST
        bookDao.delete(uuid);
        
        // CHECK
        bookDao.find(uuid);
    }
}
