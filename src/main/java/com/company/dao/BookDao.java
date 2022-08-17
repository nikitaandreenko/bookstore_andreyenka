package com.company.dao;

import com.company.entity.Book;

import java.util.List;

public interface BookDao {
    Book create(Book book);

    Book getById(Long id);

    Book getByIsbn(String isbn);

    List<Book> getAll();

    List<Book> getByAuthor(String author);

    Long countAllBooks();

    Book update(Book book);

    boolean delete(Long id);

}
