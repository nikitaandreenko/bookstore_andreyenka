package com.company.dao;

import com.company.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    public static final String GET_ALL = "SELECT id, book_name, author, isbn, price, pages, binding, year_publising " +
            "FROM books";
    public static final String GET_BY_ID = "SELECT id, book_name, author, isbn, price, pages, binding, year_publising " +
            "FROM books WHERE id = ?";

    public static final String CREATE_BOOK = "INSERT INTO books (book_name, author, isbn, price, pages, binding, " +
            "year_publising) VALUES (?, ?, ?, ?, ?, ?, ?)";

    public static final String GET_BY_ISBN = "SELECT id, book_name, author, isbn, price, pages, binding, year_publising " +
            "FROM books WHERE isbn = ?";
    public static final String UPDATE_BOOK = "UPDATE books SET book_name=?, author=?, isbn=?, price=?, pages=?, binding=?, " +
            "year_publising=? WHERE id=?";
    public static final String GET_ALL_AUTHOR = "SELECT id, book_name, author, isbn, price, pages, binding, year_publising " +
            "FROM books WHERE author =?";
    public static final String DELETE_BY_ID = "DELETE FROM books WHERE id=?";


    private final DateSourсe dateSourсe;

    public BookDaoImpl(DateSourсe dateSourсe) {
        this.dateSourсe = dateSourсe;
    }

    @Override
    public Book create(Book book) {
        try {
            Connection connection = dateSourсe.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE_BOOK, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, book.getBook_name());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getIsbn());
            statement.setBigDecimal(4, book.getPrice());
            statement.setInt(5, book.getPages());
            statement.setString(6, book.getBinding());
            statement.setInt(7, book.getYear_publising());
            if (statement.executeUpdate() == 1) {
                ResultSet resultSet = statement.getGeneratedKeys();
                Long id = resultSet.getLong(1);
                return getById(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book getById(Long id) {
        try {
            Connection connection = dateSourсe.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return process(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book getByIsbn(String isbn) {
        try {
            Connection connection = dateSourсe.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_BY_ISBN);
            statement.setString(1, isbn);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Book book = process(resultSet);
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        try {
            Connection connection = dateSourсe.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                Book book = process(resultSet);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        return book;
    }

    @Override
    public List<Book> getByAuthor(String author) {

        try {
            List<Book> books = new ArrayList<>();
            Connection connection = dateSourсe.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_ALL_AUTHOR);
            statement.setString(1, author);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = process(resultSet);
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int countAllBooks() {
        try {
            Connection connection = dateSourсe.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT count(*) AS total FROM books");
            if (resultSet.next()) {
                return resultSet.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Exception");
    }

    @Override
    public Book update(Book book) {
        try {
            Connection connection = dateSourсe.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK);
            statement.setString(1, book.getBook_name());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getIsbn());
            statement.setBigDecimal(4, book.getPrice());
            statement.setInt(5, book.getPages());
            statement.setString(6, book.getBinding());
            statement.setInt(7, book.getYear_publising());
            statement.setLong(8, book.getId());
            if (statement.executeUpdate() == 1) {
                return getById(book.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        try {
            Connection connection = dateSourсe.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID);
            statement.setLong(1, getById(id).getId());
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
