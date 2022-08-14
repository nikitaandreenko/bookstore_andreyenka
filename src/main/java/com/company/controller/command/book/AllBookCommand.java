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
    public String execute(HttpServletRequest req) {
        List<Book> books = bookService.getAll();
        req.setAttribute("all_book", books);
        req.setAttribute("message", "bookstore by Andreyenka");
        return "jsp/book/all_book.jsp";

    }
}
