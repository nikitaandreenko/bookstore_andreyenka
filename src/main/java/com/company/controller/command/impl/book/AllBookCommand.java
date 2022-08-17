package com.company.controller.command.impl.book;

import com.company.controller.command.Command;
import com.company.entity.Book;
import com.company.service.BookService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class AllBookCommand implements Command {
    private final BookService bookService;

    public AllBookCommand(com.company.service.BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        List<Book> books = bookService.getAll();
        req.setAttribute("all_books", books);
        req.setAttribute("message", "bookstore by Andreyenka");
        return "jsp/book/all_books.jsp";
    }
}
