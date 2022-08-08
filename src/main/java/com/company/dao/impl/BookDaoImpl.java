package com.company.dao.impl;

import com.company.dao.BookDao;
import com.company.dao.connection.DateSourсe;
import com.company.entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private static final Logger log = LogManager.getLogger(BookDaoImpl.class);

    public static final String GET_ALL = "SELECT books.id, books.book_name, books.author, books.isbn, books.price, "
            + "books.pages, " +
            "books.binding, books.year_publising, languages.name " +
            "FROM books JOIN languages ON language_id = languages.id";
    public static final String GET_BY_ID = "SELECT books.id, books.book_name, books.author, books.isbn, books.price, "
            + "books.pages, " +
            "books.binding, books.year_publising, languages.name " +
            "FROM books JOIN languages ON language_id = languages.id WHERE books.id = ?";

    public static final String CREATE_BOOK = "INSERT INTO books (book_name, author, isbn, price, pages, binding," +
            "year_publising, language_id) VALUES (?, ?, ?, ?, ?, ?, ?, (SELECT id FROM languages WHERE name = ?))";

    public static final String GET_BY_ISBN = "SELECT books.id, books.book_name, books.author, books.isbn, books"
            + ".price, books.pages, " +
            "books.binding, books.year_publising, languages.name " +
            "FROM books JOIN languages ON language_id = languages.id WHERE isbn = ?";
    public static final String UPDATE_BOOK = "UPDATE books SET book_name=?, author=?, isbn=?, price=?, pages=?, "
            + "binding=?, " +
            "year_publising=?, language_id = (SELECT id FROM languages WHERE name = ?) WHERE id=?";
    public static final String GET_ALL_AUTHOR = "SELECT books.id, books.book_name, books.author, books.isbn, books"
            + ".price, books.pages, " +
            "books.binding, books.year_publising, languages.name " +
            "FROM books JOIN languages ON language_id = languages.id WHERE author =?";
    public static final String DELETE_BY_ID = "DELETE FROM books WHERE id=?";


    private final DateSourсe dateSourсe;

    public BookDaoImpl(DateSourсe dateSourсe) {
        this.dateSourсe = dateSourсe;
    }

    @Override
    public Book create(Book book) {
        log.debug("Create book={} in database book", book);
        Connection connection = dateSourсe.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE_BOOK)) {
            statement.setString(1, book.getBook_name());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getIsbn());
            statement.setBigDecimal(4, book.getPrice());
            statement.setInt(5, book.getPages());
            statement.setString(6, book.getBinding());
            statement.setInt(7, book.getYear_publising());
            statement.setString(8, book.getLanguage().toString());
            if (statement.executeUpdate() == 1) {
                return getByIsbn(book.getIsbn());
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Book getById(Long id) {
        log.debug("Get book by id from database books");
        Connection connection = dateSourсe.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(GET_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return process(resultSet);
            }
        } catch (SQLException e) {
            log.error("SQLException" + e);
        }
        return null;
    }

    @Override
    public Book getByIsbn(String isbn) {
        log.debug("Get book by isbn from database books");
        Connection connection = dateSourсe.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(GET_BY_ISBN)) {
            statement.setString(1, isbn);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Book book = process(resultSet);
                return book;
            }
        } catch (SQLException e) {
            log.error("SQLException" + e);
        }
        return null;
    }

    @Override
    public List<Book> getAll() {
        log.debug("Get all books from database books");
        List<Book> books = new ArrayList<>();
        Connection connection = dateSourсe.getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                Book book = process(resultSet);
                books.add(book);
            }
        } catch (SQLException e) {
            log.error("SQLException" + e);
        }
        return books;
    }

    private Book process(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getLong("id"));
        book.setBook_name(resultSet.getString("book_name"));
        book.setAuthor(resultSet.getString("author"));
        book.setIsbn(resultSet.getString("isbn"));
        book.setPrice(resultSet.getBigDecimal("price"));
        book.setPages(resultSet.getInt("pages"));
        book.setBinding(resultSet.getString("binding"));
        book.setYear_publising(resultSet.getInt("year_publising"));
        book.setLanguage(Book.Language.valueOf(resultSet.getString("name")));
        return book;
    }

    @Override
    public List<Book> getByAuthor(String author) {
        log.debug("Get book by author from database books");
        List<Book> books = new ArrayList<>();
        Connection connection = dateSourсe.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_AUTHOR)) {
            statement.setString(1, author);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = process(resultSet);
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            log.error("SQLException" + e);
        }
        return null;
    }

    @Override
    public int countAllBooks() {
        log.debug("Count all books from database books");
        Connection connection = dateSourсe.getConnection();
        try (Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery("SELECT count(*) AS total FROM books");
            if (resultSet.next()) {
                return resultSet.getInt("total");
            }
        } catch (SQLException e) {
            log.error("SQLException" + e);
        }
        throw new RuntimeException("Exception");
    }

    @Override
    public Book update(Book book) {
        log.debug("Update book in database books");
        Connection connection = dateSourсe.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK)) {
            statement.setString(1, book.getBook_name());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getIsbn());
            statement.setBigDecimal(4, book.getPrice());
            statement.setInt(5, book.getPages());
            statement.setString(6, book.getBinding());
            statement.setInt(7, book.getYear_publising());
            statement.setString(8, book.getLanguage().toString());
            statement.setLong(9, book.getId());
            if (statement.executeUpdate() == 1) {
                return getById(book.getId());
            }
        } catch (SQLException e) {
            log.error("SQLException" + e);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        log.debug("Delete book from database books");
        Connection connection = dateSourсe.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setLong(1, getById(id).getId());
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            log.error("SQLException " + e);
        }
        return false;
    }
}
