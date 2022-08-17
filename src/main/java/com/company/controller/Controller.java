package com.company.controller;

import com.company.controller.command.impl.Command;
import com.company.controller.command.CommandFactory;
import com.company.dao.connection.DateSourсe;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    private DateSourсe dateSourсe;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String commandParam = req.getParameter("command");
        Command command;
        if (CommandFactory.INSTANCE.getCommand(commandParam) == null) {
            command = CommandFactory.INSTANCE.getCommand("error");
        } else {
            command = CommandFactory.INSTANCE.getCommand(commandParam);
        }
        String page;
        try {
            page = command.execute(req);
        } catch (Exception e) {
            req.setAttribute("message", "My friend please write correctly what you want to see in my store");
            page = "jsp/error.jsp";
        }
        req.getRequestDispatcher(page).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    public void destroy() {
        DateSourсe.INSTANCE.close();
    }
}

