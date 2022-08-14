package com.company.controller.command.user;

import com.company.controller.command.impl.Command;
import com.company.entity.User;
import com.company.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AllUserCommand implements Command {

    private final UserService userService;

    public AllUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        List<User> users = userService.getAll();
        req.setAttribute("all_user", users);
        return "jsp/user/all_user.jsp";
    }
}
