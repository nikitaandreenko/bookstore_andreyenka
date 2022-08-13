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
import java.util.List;

@WebServlet("/allbook")
public class BookControllerAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DateSourсe dateSourсe = new DateSourсe();
        BookDaoImpl bookDao = new BookDaoImpl(dateSourсe);
        BookService bookService = new BookService(bookDao);
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        List<Book> books = bookService.getAll();
        writer.write("<style>.b1 {\n" +
                "    background: navy;\n" +
                "    color: white;\n" +
                "    font-size: 9pt;\n" +
                "   } </style>");

        writer.write("<style>.table {\n" +
                "    width: 300px;\n" +
                "    border: 2px solid\n" +
                "   }" +
                "td { " +
                "text-align: center;}" +
                "</style>");
        writer.write("<h1 align=\"center\">Books</h1>");
        books.forEach(book ->
                writer.write("<table align=\"center\" class = \"table\">" + "<tr>" + "<th>" + "Name" + "</th>" +
                        "<th>" + "Author" + "</th>" +
                        "<th>" + "Year publishing" + "</th>" +
                        "<tr>" +
                        "<td>" +
                        "<button onclick=\"window.location.href='http://localhost:8080/bookstore/book?id="+book.getId()+
                        "';\" class =\"b1\">" + book.getBook_name() + "</button>" + "</td>" +
                        "<td>" + book.getAuthor() + "</td>" +
                        "<td>" + book.getYear_publishing() + "</td>"
                        + "</tr>"
                        + "</table>"));

    }
}
