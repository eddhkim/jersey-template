package com.eddhkim.template.dao;

import java.util.UUID;

import com.eddhkim.template.entity.Book;

public interface BookDao {
    void save(Book book);
    Book find(UUID uuid);
    void update(Book book);
    void delete(UUID uuid);
}
