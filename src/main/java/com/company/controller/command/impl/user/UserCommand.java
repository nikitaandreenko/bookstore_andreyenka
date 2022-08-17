package com.company.controller.command.impl.user;

import com.company.controller.command.Command;
import com.company.entity.User;
import com.company.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

public class UserCommand implements Command {

    private final com.company.service.UserService userService;

    public UserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        String idRaw = req.getParameter("id");
        Long id = Long.parseLong(idRaw);
        User user = userService.getById(id);
        req.setAttribute("user", user);
        req.setAttribute("message", "bookstore by Andreyenka");
        return "jsp/user/user.jsp";
    }
}
