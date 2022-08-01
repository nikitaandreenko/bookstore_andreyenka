package com.company.util;

import com.company.dao.BookDao;
import com.company.dao.BookDaoImpl;
import com.company.dao.DateSourse;
import com.company.model.Book;

import java.math.BigDecimal;
import java.util.List;

public class App {
    public static void main(String[] args) {
        BookDao bookDao = new BookDaoImpl(new DateSourse());
//      List<Book> books = bookDao.getAll();
//        System.out.println("All books:");
//        books.forEach(System.out::println);
//        System.out.println("Book by id:");
//        Book book1 = bookDao.getById(3L);
//        System.out.println(book1);
//        System.out.println("Book by isbn:");
//        Book book2 = bookDao.getBookByIsbn("978-1668001226");
//        System.out.println(book2);
//        Book book3 = new Book();
//        book3.setBook_name("Verity");
//        book3.setAuthor("Collen Hoover");
//        book3.setIsbn("978-1538724736");
//        book3.setPrice(BigDecimal.valueOf(12.99));
//        book3.setPages(426);
//        book3.setBinding("solid");
//        book3.setYear_publising(2019);
//        Book book4 = bookDao.create(book3);
//        System.out.println("Created book");
//        System.out.println(book4);
//        List<Book> booksAuthors = bookDao.getBooksByAuthor("John Grisham");
//        System.out.println("All books John Grisham:");
//        booksAuthors.forEach(System.out::println);
//        System.out.println(bookDao.delete(22L));
//        Book book3 = new Book();
//        book3.setId(3L);
//        book3.setBook_name("I train update books");
//        book3.setAuthor("Collen Hoover");
//        book3.setIsbn("978-1533723738");
//        book3.setPrice(BigDecimal.valueOf(11.99));
//        book3.setPages(326);
//        book3.setBinding("solid");
//        book3.setYear_publising(2019);
//        Book book4 = bookDao.update(book3);
//        System.out.println("Update book: ");
//        System.out.println(book4);
//      int count = bookDao.countAllBooks();
//      System.out.println("Count books: " + count);


    }

}
