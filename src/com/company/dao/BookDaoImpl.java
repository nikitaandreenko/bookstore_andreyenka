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

    public static final String CREATE_BOOK = "INSERT INTO books (book_name, author, isbn, price, pages, binding, year_publising) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";

    public static final String GET_BY_ISBN = "SELECT id, book_name, author, isbn, price, pages, binding, year_publising FROM books WHERE isbn = ?";
    public static final String UPDATE_BOOK = "UPDATE books SET book_name=?, author=?, isbn=?, price=?, pages=?, binding=?, year_publising=? WHERE id=?";
    public static final String GET_ALL_AUTHOR = "SELECT id, book_name, author, isbn, price, pages, binding, year_publising FROM books WHERE author =?";
    public static final String DELETE_BY_ID = "DELETE FROM books WHERE id=?";


    private final DateSourсe datasourse;

    public BookDaoImpl(DateSourсe datasourse) {
        this.datasourse = datasourse;
    }

    @Override
    public Book create(Book book) {
        try {
            Connection connection = datasourse.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE_BOOK);
            statement.setString(1, book.getBook_name());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getIsbn());
            statement.setBigDecimal(4, book.getPrice());
            statement.setInt(5, book.getPages());
            statement.setString(6, book.getBinding());
            statement.setInt(7, book.getYear_publising());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getBookByIsbn(book.getIsbn());
    }

    @Override
    public Book getById(Long id) {
        try {
            Connection connection = datasourse.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        try {
            Connection connection = datasourse.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_BY_ISBN);
            statement.setString(1, isbn);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        try {
            Connection connection = datasourse.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setBook_name(resultSet.getString("book_name"));
                book.setAuthor(resultSet.getString("author"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setPrice(resultSet.getBigDecimal("price"));
                book.setPages(resultSet.getInt("pages"));
                book.setBinding(resultSet.getString("binding"));
                book.setYear_publising(resultSet.getInt("year_publising"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        List<Book> books = new ArrayList<>();
        try {
            Connection connection = datasourse.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_ALL_AUTHOR);
            statement.setString(1, author);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setBook_name(resultSet.getString("book_name"));
                book.setAuthor(resultSet.getString("author"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setPrice(resultSet.getBigDecimal("price"));
                book.setPages(resultSet.getInt("pages"));
                book.setBinding(resultSet.getString("binding"));
                book.setYear_publising(resultSet.getInt("year_publising"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public int countAllBooks() {
        List<Book> books = getAll();
        int count = 0;
        for (int i = 0; i < books.size(); i++) {
            count += 1;
        }
        return count;
    }

    @Override
    public Book update(Book book) {
        try {
            Connection connection = datasourse.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK);
            statement.setString(1, book.getBook_name());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getIsbn());
            statement.setBigDecimal(4, book.getPrice());
            statement.setInt(5, book.getPages());
            statement.setString(6, book.getBinding());
            statement.setInt(7, book.getYear_publising());
            statement.setLong(8, book.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getById(book.getId());
    }

    @Override
    public boolean delete(Long id) {
        try {
            Connection connection = datasourse.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID);
            statement.setLong(1, getById(id).getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
