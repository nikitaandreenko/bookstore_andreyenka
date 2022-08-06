import com.company.dao.BookDao;
import com.company.dao.BookDaoImpl;
import com.company.dao.DateSourсe;
import com.company.dao.UserDaoImpl;
import com.company.entity.Book;
import com.company.controller.BookController;
import com.company.entity.User;
import com.company.service.BookService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DateSourсe dateSourсe = new DateSourсe();
        BookController.info();
    }
}