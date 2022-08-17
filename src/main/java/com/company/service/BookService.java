package com.company.service;

import com.company.entity.Book;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {
    Book create(Book book);

    Book getById(Long id);

    Book getByIsbn(String isbn);

    List<Book> getAll();

    List<Book> getByAuthor(String author);

    Long countAllBooks();

    Book update(Book book);

    void delete(Long id);

    BigDecimal totalPriceByAuthor(String author);
}
