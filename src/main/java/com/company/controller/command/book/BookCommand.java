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
        req.setAttribute("message","bookstore by Andreyenka");
        return "jsp/book/book.jsp";
    }
}
