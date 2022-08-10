package com.company.controller;


import com.company.dao.BookDaoImpl;

import com.company.dao.connection.DateSourсe;
import com.company.entity.Book;
import com.company.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/book")
public class BookControllerById extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DateSourсe dateSourсe = new DateSourсe();
        BookDaoImpl bookDao = new BookDaoImpl(dateSourсe);
        BookService bookService = new BookService(bookDao);
        String idRaw = req.getParameter("id");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        Long id = Long.parseLong(idRaw);
        Book book = bookService.getById(id);
        writer.write("<h1>" + book.getBook_name() + " " + book.getAuthor() + " "
                + book.getYear_publishing() + "</h1>");
    }
}
