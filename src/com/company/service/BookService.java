package com.company.service;

import com.company.dao.BookDaoImpl;
import com.company.entity.Book;

import java.util.List;

public class BookService {

    private BookDaoImpl bookDao;

    public BookService (){
        bookDao = new BookDaoImpl();
    }
    public Book create(Book book) {
        return bookDao.create(book);
    }
    public Book getById(Long id){
        return bookDao.getById(id);
    }
    public Book getByIsbn(String isbn){
        return bookDao.getByIsbn(isbn);
    }

    public List<Book> getAll(){
        return bookDao.getAll();
    }
    public List<Book> getByAuthor(String author){
        return bookDao.getByAuthor(author);
    }
    public int countAllBooks(){
        return bookDao.countAllBooks();
    }
    public void delete(Long id){
        bookDao.delete(id);
    }






}
