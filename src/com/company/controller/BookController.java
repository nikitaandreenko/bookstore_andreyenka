package com.company.controller;

import com.company.dao.BookDao;
import com.company.entity.Book;

import java.util.List;

public class BookController {
    private BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    public void info(String command) {
        boolean commandBol = false;
        while (!commandBol) {
            if (command.contains("all")) {
                commandBol = all();
            } else if (command.contains("get")) {
                commandBol = get(command);
            } else if (command.contains("delete")) {
                commandBol = delete(command);
            } else if (command.equalsIgnoreCase("exit")) {
                System.out.println("End app");
                commandBol = true;
            }
        }
    }

    private boolean delete(String command) {
        boolean commandBol;
        String[] words = command.split(" ");
        String firstCommandUser = words[0];
        Long secondCommandUser = Long.parseLong(words[1]);
        System.out.println(bookDao.delete(secondCommandUser));
        commandBol = true;
        return commandBol;
    }

    private boolean get(String command) {
        boolean commandBol;
        String[] words = command.split(" ");
        String firstCommandUser = words[0];
        Long secondCommandUser = Long.parseLong(words[1]);
        Book book = bookDao.getById(secondCommandUser);
        System.out.println(book);
        commandBol = true;
        return commandBol;
    }

    private boolean all() {
        boolean commandBol;
        List<Book> books = bookDao.getAll();
        books.forEach(book ->
                System.out.println(book.getId() + " " + book.getBook_name() + " " + book.getAuthor() + " "
                        + book.getYear_publising()));
        commandBol = true;
        return commandBol;
    }
}
