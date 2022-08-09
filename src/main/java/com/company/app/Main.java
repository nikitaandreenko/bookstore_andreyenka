package com.company.app;

import com.company.dao.BookDaoImpl;
import com.company.dao.connection.DateSourсe;

import com.company.controller.BookController;

import com.company.service.BookService;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        DateSourсe dateSourсe = new DateSourсe();
        BookDaoImpl bookDao = new BookDaoImpl(dateSourсe);
        BookService bookService = new BookService(bookDao);
        BookController bookController = new BookController(bookService);
        bookController.info();
        dateSourсe.close();
    }
}