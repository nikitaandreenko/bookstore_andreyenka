package com.company.controller;

import com.company.dao.BookDao;
import com.company.dao.BookDaoImpl;
import com.company.dao.DateSourсe;
import com.company.entity.Book;
import com.company.service.BookService;

import java.util.List;
import java.util.Scanner;

public class BookController {
    private BookService bookService;

    public BookController() {

        bookService = new BookService();
    }

    public void info() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter command");
        String command = in.nextLine();
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
        System.out.println(bookService.delete(secondCommandUser));
        commandBol = true;
        return commandBol;
    }

    private boolean get(String command) {
        boolean commandBol;
        String[] words = command.split(" ");
        String firstCommandUser = words[0];
        Long secondCommandUser = Long.parseLong(words[1]);
        Book book = bookService.getById(secondCommandUser);
        System.out.println(book);
        commandBol = true;
        return commandBol;
    }

    private boolean all() {
        boolean commandBol;
        List<Book> books = bookService.getAll();
        books.forEach(book ->
                System.out.println(book.getId() + " " + book.getBook_name() + " " + book.getAuthor() + " "
                        + book.getYear_publising()));
        commandBol = true;
        return commandBol;
    }

    public void createBookFromConsole() {
        Book book = new Book();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name book");
        book.setBook_name(in.nextLine());
        System.out.println("Enter author book");
        book.setAuthor(in.nextLine());
        System.out.println("Enter isbn book");
        book.setIsbn(in.nextLine());
        System.out.println("Enter price book");
        book.setPrice(in.nextBigDecimal());
        System.out.println("Enter count of pages");
        book.setBinding(in.nextLine());
        System.out.println("Enter year_bublising");
        book.setYear_publising(in.nextInt());
        bookService.create(book);
    }

    public void updateBookFromConsole() {
        Book book = new Book();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name book");
        book.setBook_name(in.nextLine());
        System.out.println("Enter author book");
        book.setAuthor(in.nextLine());
        System.out.println("Enter isbn book");
        book.setIsbn(in.nextLine());
        System.out.println("Enter price book");
        book.setPrice(in.nextBigDecimal());
        System.out.println("Enter count of pages");
        book.setBinding(in.nextLine());
        System.out.println("Enter year_bublising");
        book.setYear_publising(in.nextInt());
        bookService.update(book);
    }
}
