package com.company.dao;

import java.util.List;

public interface BookDao {
    //Create
    Book create(Book book);
    //Read
    Book getById (Long id);
    Book getBookByIsbn (String isbn);
    List<Book> getAll();
    List <Book> getBooksByAuthor (String author);
    int countAllBooks();
    //Update
    Book update(Book book);
    //Delete
    boolean delete (Long id);

}
