package com.company.dao;

import com.company.entity.Book;

import java.util.List;

public interface BookDao extends AbstractDao<Long, Book> {
    Book getByIsbn(String isbn);

    List<Book> getByAuthor(String author);
}
