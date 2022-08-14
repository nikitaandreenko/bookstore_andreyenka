package com.company.controller.command.book;

import com.company.controller.command.impl.Command;
import com.company.entity.Book;
import com.company.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AllBookCommand implements Command {
    private final BookService bookService;

    public AllBookCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest req){
        List<Book> books = bookService.getAll();
        req.setAttribute("all_book",books);
        return "jsp/book/all_book.jsp";
//        <a href="controller?command=book&id="${book.id}>
        //подразумевается под запросом all_book объект books
//        writer.write("<style>.b1 {\n" +
//                "    background: navy;\n" +
//                "    color: white;\n" +
//                "    font-size: 9pt;\n" +
//                "   } </style>");
//
//        writer.write("<style>.table {\n" +
//                "    width: 300px;\n" +
//                "    border: 2px solid\n" +
//                "   }" +
//                "td { " +
//                "text-align: center;}" +
//                "</style>");
//        writer.write("<h1 align=\"center\">Books</h1>");
//        books.forEach(book ->
//                writer.write("<table align=\"center\" class = \"table\">" + "<tr>" + "<th>" + "Name" + "</th>" +
//                        "<th>" + "Author" + "</th>" +
//                        "<th>" + "Year publishing" + "</th>" +
//                        "<tr>" +
//                        "<td>" +
//                        "<button onclick=\"window.location.href='http://localhost:8080/bookstore/book?id="+book.getId()+
//                        "';\" class =\"b1\">"  + book.getBook_name() + "</button>" + "</td>" +
//                        "<td>" + book.getAuthor() + "</td>" +
//                        "<td>" + book.getYear_publishing() + "</td>"
//                        + "</tr>"
//                        + "</table>"));

    }
}
