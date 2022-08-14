package com.company.controller.command.book;


import com.company.controller.command.impl.Command;
import com.company.entity.Book;
import com.company.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

public class BookCommand implements Command {

    private final BookService bookService;

    public BookCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest req){
        String idRaw = req.getParameter("id");
        Long id = Long.parseLong(idRaw);
        Book book = bookService.getById(id);
        req.setAttribute("book",book);
        return "book.jsp";
//        writer.write("<style>.text {\n" +
//                "    font-size: 120%;\n" +
//                "    font-family: Arial, Helvetica, sans-serif;\n" +
//                "    color: green;\n" +
//                "   } </style>");
//        writer.write("<h1 align=\"center\">Book</h1>");
//        writer.write("<h3 align=\"center\" class = \"text\">" + book.getBook_name() + " " + book.getAuthor() + " "
//                + book.getYear_publishing() + "</h3>");
    }
}
