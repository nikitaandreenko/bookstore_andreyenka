package com.company.controller.command;

import com.company.controller.command.impl.book.AllBookCommand;
import com.company.controller.command.impl.book.BookCommand;
import com.company.controller.command.impl.error.ErrorCommand;
import com.company.controller.command.impl.user.AllUserCommand;
import com.company.controller.command.impl.user.CreateUserCommand;
import com.company.controller.command.impl.user.UserCommand;
import com.company.dao.impl.BookDaoImpl;
import com.company.dao.impl.UserDaoImpl;
import com.company.dao.connection.DateSourсe;
import com.company.service.BookService;
import com.company.service.UserService;
import com.company.service.impl.BookServiceImpl;
import com.company.service.impl.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    public static final CommandFactory INSTANCE = new CommandFactory();
    public final Map<String, Command> commandMap;

    private CommandFactory() {
        commandMap = new HashMap<>();
        BookService bookService = new BookServiceImpl(new BookDaoImpl(DateSourсe.INSTANCE));
        commandMap.put("book", new BookCommand(bookService));
        commandMap.put("all_books", new AllBookCommand(bookService));
        UserService userService = new UserServiceImpl(new UserDaoImpl(DateSourсe.INSTANCE));
        commandMap.put("all_users", new AllUserCommand(userService));
        commandMap.put("user", new UserCommand(userService));
        commandMap.put("error", new ErrorCommand());
        commandMap.put("create_user", new CreateUserCommand(userService));
    }

    public Command getCommand(String command) {
        return commandMap.get(command);
    }
}
