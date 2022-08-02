import com.company.dao.BookDao;
import com.company.dao.BookDaoImpl;
import com.company.dao.DateSourсe;
import com.company.model.Book;
import com.company.controller.BookController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DateSourсe dateSourсe = new DateSourсe();
        BookDao bookDao = new BookDaoImpl(dateSourсe);
        BookController bookController = new BookController(bookDao);
        Book book = new Book();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter command");
        bookController.info(in.nextLine());
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
        bookDao.create(book);
        bookDao.update(book);
    }
}