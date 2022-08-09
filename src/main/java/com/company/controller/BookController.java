package com.company.controller;

import com.company.dao.BookDaoImpl;
import com.company.dao.connection.DateSourсe;
import com.company.entity.Book;
import com.company.service.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class BookController {
    private static BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public void info() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter command");
        String command = in.nextLine();
        boolean commandBol = false;
        while (!commandBol) {
            if (command.contains("all")) {
                all();
                commandBol = true;
            } else if (command.contains("get")) {
                get(command);
                commandBol = true;
            } else if (command.contains("delete")) {
                delete(command);
                commandBol = true;
            } else if (command.equalsIgnoreCase("exit")) {
                System.out.println("End app");
                commandBol = true;
            }
        }
    }

    private void delete(String command) {
        String[] words = command.split(" ");
        String firstCommandUser = words[0];
        Long secondCommandUser = Long.parseLong(words[1]);
        bookService.delete(secondCommandUser);
    }

    private void get(String command) {
        String[] words = command.split(" ");
        String firstCommandUser = words[0];
        Long secondCommandUser = Long.parseLong(words[1]);
        Book book = bookService.getById(secondCommandUser);
        System.out.println(book);
    }

    private void all() {
        boolean commandBol;
        List<Book> books = bookService.getAll();
        books.forEach(book ->
                System.out.println(book.getId() + " " + book.getBook_name() + " " + book.getAuthor() + " "
                        + book.getYear_publishing()));
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
        book.setYear_publishing(in.nextInt());
        System.out.println("Enter language ");
        book.setLanguage(Book.Language.valueOf((in.nextLine()).toUpperCase()));
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
        book.setYear_publishing(in.nextInt());
        System.out.println("Enter language ");
        book.setLanguage(Book.Language.valueOf((in.nextLine()).toUpperCase()));
        bookService.update(book);
    }
}
