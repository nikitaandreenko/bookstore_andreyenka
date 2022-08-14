package com.company.controller.command.error;

import com.company.controller.command.impl.Command;
import jakarta.servlet.http.HttpServletRequest;

public class ErrorCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        req.setAttribute("message", "My friend please write correctly what you want to see in my store");
        return "jsp/error.jsp";
    }
}
