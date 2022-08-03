package com.company.service;

import com.company.dao.BookDaoImpl;
import com.company.entity.Book;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {

    private BookDaoImpl bookDao;

    public BookService() {
        bookDao = new BookDaoImpl();
    }

    public Book create(Book book) {
        return bookDao.create(book);
    }

    public Book getById(Long id) {
        return bookDao.getById(id);
    }

    public Book getByIsbn(String isbn) {
        return bookDao.getByIsbn(isbn);
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }

    public List<Book> getByAuthor(String author) {
        return bookDao.getByAuthor(author);
    }

    public int countAllBooks() {
        return bookDao.countAllBooks();
    }

    public Book update(Book book) {
        return bookDao.update(book);
    }

    public boolean delete(Long id) {
        return bookDao.delete(id);
    }

//    public BigDecimal  totalPriceByAuthor(String author){
//        List <Book> books = getByAuthor(author);
//        BigDecimal bigDecimal = new BigDecimal(0.00);
//        List <BigDecimal> totals = books.stream().map(book -> book.getPrice()).toList();
//        for (BigDecimal l : totals){
//            bigDecimal.add(l);
//        }
//        return bigDecimal;
//    }


}
