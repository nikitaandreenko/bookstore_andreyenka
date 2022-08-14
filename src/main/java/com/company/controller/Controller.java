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

@WebServlet("/controller") //localhost:8080/bookstore/controller?command=
// allbook,alluser, create_book_form,create_user_form, update_book_form, update_user_form, book&id=5,
public class Controller extends HttpServlet {
    private DateSourсe dateSourсe;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandParam = req.getParameter("command");
        Command command = CommandFactory.INSTANCE.getCommand(commandParam);
        String page = command.execute(req);
        req.getRequestDispatcher(page).forward(req, resp);
    }
    @Override
    public void destroy() {
        DateSourсe.INSTANCE.close();
    }
}

