package com.company.controller.command;

import com.company.controller.command.book.AllBookCommand;
import com.company.controller.command.book.BookCommand;
import com.company.controller.command.impl.Command;
import com.company.controller.command.user.AllUserCommand;
import com.company.controller.command.user.UserCommand;
import com.company.dao.BookDaoImpl;
import com.company.dao.UserDaoImpl;
import com.company.dao.connection.DateSourсe;
import com.company.service.BookService;
import com.company.service.UserService;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    public static final CommandFactory INSTANCE = new CommandFactory();
    public final Map<String, Command> commandMap;

    private CommandFactory() {
        commandMap = new HashMap<>();
        BookService bookService= new BookService(new BookDaoImpl(DateSourсe.INSTANCE));
        commandMap.put("book",new BookCommand(bookService));
        commandMap.put("all_book",new AllBookCommand(bookService));
        UserService userService = new UserService(new UserDaoImpl(DateSourсe.INSTANCE));
        commandMap.put("user",new AllUserCommand(userService));
        commandMap.put("all_user", new UserCommand(userService));
    }

    public Command getCommand(String command) {
        return commandMap.get(command);
    }
}
