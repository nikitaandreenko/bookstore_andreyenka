package com.company.controller;

import com.company.dao.BookDaoImpl;
import com.company.dao.UserDaoImpl;
import com.company.dao.connection.DateSourсe;
import com.company.entity.Book;
import com.company.entity.User;
import com.company.service.BookService;
import com.company.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/alluser")
public class UserControllerAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DateSourсe dateSourсe = new DateSourсe();
        UserDaoImpl userDao = new UserDaoImpl(dateSourсe);
        UserService userService = new UserService(userDao);
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        List<User> users = userDao.getAll();
        users.forEach(user ->
                writer.write("<h1>" + user.getFirstName() + " " + user.getFirstName() + " "
                        + user.getRole() + "</h1>"));
    }
}
