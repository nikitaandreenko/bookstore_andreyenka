package com.company.controller.command.user;

import com.company.controller.command.impl.Command;
import com.company.entity.User;
import com.company.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class UserCommand implements Command {

    private final UserService userService;

    public UserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req){
        String idRaw = req.getParameter("id");
        Long id = Long.parseLong(idRaw);
        User user = userService.getById(id);
        req.setAttribute("user",user);
        return "jsp/user/user.jsp";
    }
}
