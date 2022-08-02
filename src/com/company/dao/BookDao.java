package com.company.dao;

import com.company.model.Book;

import java.util.List;

public interface BookDao {
    //Create
    Book create(Book book);

    //Read
    Book getById(Long id);

    Book getByIsbn(String isbn);

    List<Book> getAll();

    List<Book> getBooksByAuthor(String author);

    int countAllBooks();

    //Update
    Book update(Book book);

    //Delete
    boolean delete(Long id);

}
