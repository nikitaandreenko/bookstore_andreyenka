package com.company.service;

import com.company.dao.BookDao;
import com.company.dao.BookDaoImpl;
import com.company.dao.DateSourсe;
import com.company.model.Book;

import java.util.List;

public class UserService {
    private BookDao bookDao = new BookDaoImpl(new DateSourсe());
    ;

    public void info(String command) {
        boolean commandBol = false;
        while (!commandBol) {
            if (command.equalsIgnoreCase("all")) {
                List<Book> books = bookDao.getAll();
                books.forEach(book ->
                        System.out.println(book.getId() + " " + book.getBook_name() + " " + book.getAuthor() + " " + book.getYear_publising()));
                commandBol = true;
            } else if (command.contains("get")) {
                String[] words = command.split(" ");
                String firstCommandUser = words[0];
                Long secondCommandUser = Long.parseLong(words[1]);
                Book book = bookDao.getById(secondCommandUser);
                System.out.println(book);
                commandBol = true;
            } else if (command.contains("delete")) {
                String[] words = command.split(" ");
                String firstCommandUser = words[0];
                Long secondCommandUser = Long.parseLong(words[1]);
                System.out.println(bookDao.delete(secondCommandUser));
                commandBol = true;
            } else if (command.equalsIgnoreCase("exit")) {
                System.out.println("End app");
                commandBol = true;
            }
        }
    }

}
