package com.company.controller.command.impl.user;

import com.company.controller.command.Command;
import com.company.entity.User;
import com.company.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class AllUserCommand implements Command {

    private final com.company.service.UserService userService;

    public AllUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        List<User> users = userService.getAll();
        req.setAttribute("all_users", users);
        req.setAttribute("message", "bookstore by Andreyenka");
        return "jsp/user/all_users.jsp";
    }
}
