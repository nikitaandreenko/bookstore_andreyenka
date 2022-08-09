package com.company.service;

import com.company.dao.BookDaoImpl;
import com.company.entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;

public class BookService {
    private static final Logger log = LogManager.getLogger(BookService.class);

    private final BookDaoImpl bookDao;

    public BookService(BookDaoImpl bookDao) {
        this.bookDao = bookDao;
    }

    public Book create(Book book) {
        log.debug("Create book={} in database book", book);
        return bookDao.create(book);
    }

    public Book getById(Long id) {
        log.debug("Get book by id={} from database books", id);
        Book book = bookDao.getById(id);
        if (book == null) {
            throw new RuntimeException("Book with id:" + id + " doesn't exist");
        }
        return book;
    }

    public Book getByIsbn(String isbn) {
        log.debug("Get book by isbn={} from database books", isbn);
        Book book = bookDao.getByIsbn(isbn);
        if (book == null) {
            throw new RuntimeException("Book with isbn:" + isbn + " doesn't exist");
        }
        return book;
    }

    public List<Book> getAll() {
        log.debug("Get all books from database books");
        return bookDao.getAll();
    }

    public List<Book> getByAuthor(String author) {
        log.debug("Get book by author={} from database books", author);
        return bookDao.getByAuthor(author);
    }

    public Long countAllBooks() {
        log.debug("Count all books from database books");
        return bookDao.countAllBooks();
    }

    public Book update(Book book) {
        log.debug("Update book={} in database books", book);
        Book book1 = bookDao.update(book);
        if (book1 == null) {
            throw new RuntimeException("Books can't be empty...");
        }
        return book1;
    }

    public void delete(Long id) {
        log.debug("Delete book by id={} from database books", id);
        boolean successRemove = bookDao.delete(id);
        if (!successRemove) {
            throw new RuntimeException("This book doesn't remove");
        }
    }

    public BigDecimal totalPriceByAuthor(String author) {
        log.debug("Total books by author={} from database books", author);
        List<Book> books = getByAuthor(author);
        BigDecimal total = books.stream().map(Book::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        return total;
    }
}
