import com.company.dao.BookDao;
import com.company.dao.BookDaoImpl;
import com.company.dao.DateSourсe;
import com.company.entity.Book;
import com.company.controller.BookController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DateSourсe dateSourсe = new DateSourсe();
        BookDao bookDao = new BookDaoImpl();
        BookController bookController = new BookController(bookDao);
        bookController.info();
//        bookController.createBookFromConsole();
//        bookController.updateBookFromConsole();
    }
}