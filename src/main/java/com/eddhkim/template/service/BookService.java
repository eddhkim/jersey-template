package com.eddhkim.template.service;

import com.eddhkim.template.entity.Book;

public interface BookService {
    void add(Book book);
    Book find(String uuid);
    void update(Book book);
    void remove(String uuid);
}
