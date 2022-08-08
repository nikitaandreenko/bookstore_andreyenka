package com.company.service;

import com.company.dao.BookDaoImpl;
import com.company.entity.Book;
import com.company.util.LoggerBookstore;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {

    private final BookDaoImpl bookDao;

    public BookService(BookDaoImpl bookDao) {
        this.bookDao = bookDao;
    }

    public Book create(Book book) {
        return bookDao.create(book);
    }

    public Book getById(Long id) {
        Book book = bookDao.getById(id);
        if (book == null) {
            throw new RuntimeException("Book with id:" + id + " doesn't exist");
        }
        return book;
    }

    public Book getByIsbn(String isbn) {
        Book book = bookDao.getByIsbn(isbn);
        if (book == null) {
            throw new RuntimeException("Book with isbn:" + isbn + " doesn't exist");
        }
        return book;
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }

    public List<Book> getByAuthor(String author) {
        List<Book> books = bookDao.getByAuthor(author);
        if (books == null) {
            throw new RuntimeException("Books by author:" + author + " don't exist");
        }
        return books;
    }

    public int countAllBooks() {
        return bookDao.countAllBooks();
    }

    public Book update(Book book) {
        Book book1 = bookDao.update(book);
        if (book1 == null) {
            throw new RuntimeException("Books can't be empty...");
        }
        return book1;
    }

    public void delete(Long id) {
        boolean successRemove = bookDao.delete(id);
        if (!successRemove) {
            throw new RuntimeException("This book doesn't remove");
        }
    }

    public BigDecimal totalPriceByAuthor(String author) {
        List<Book> books = getByAuthor(author);
        BigDecimal total = books.stream().map(Book::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        return total;
    }
}
