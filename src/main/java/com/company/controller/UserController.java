package com.company.controller;

import com.company.dao.connection.DateSourсe;
import com.company.dao.UserDaoImpl;
import com.company.entity.User;
import com.company.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;
import java.util.Scanner;

public class UserController {
    private static UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public static void info() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter command");
        String command = in.nextLine();
        boolean commandBol = false;
        while (!commandBol) {
            if (command.contains("all")) {
                all();
                commandBol = true;
            } else if (command.contains("get")) {
                get(command);
                commandBol = true;
            } else if (command.contains("delete")) {
                delete(command);
                commandBol = true;
            } else if (command.equalsIgnoreCase("exit")) {
                System.out.println("End app");
                commandBol = true;
            }
        }
    }

    private static void delete(String command) {
        String[] words = command.split(" ");
        String firstCommandUser = words[0];
        Long secondCommandUser = Long.parseLong(words[1]);
        userService.delete(secondCommandUser);
    }

    private static void get(String command) {
        String[] words = command.split(" ");
        String firstCommandUser = words[0];
        Long secondCommandUser = Long.parseLong(words[1]);
        User user = userService.getById(secondCommandUser);
        System.out.println(user);
    }

    private static void all() {
        boolean commandBol;
        List<User> users = userService.getAll();
        users.forEach(user ->
                System.out.println(user.getId() + " " + user.getFirstName() + " " + user.getLastName()));
    }

    public static void createUserFromConsole() {
        User user = new User();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter first name");
        user.setFirstName(in.nextLine());
        System.out.println("Enter last name");
        user.setLastName(in.nextLine());
        System.out.println("Enter age");
        user.setAge(in.nextInt());
        System.out.println("Enter email");
        user.setEmail(in.nextLine());
        System.out.println("Enter role");
        user.setRole(User.Role.valueOf((in.nextLine()).toUpperCase()));
        userService.create(user);
    }

    public static void updateUserFromConsole() {
        User user = new User();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter first name");
        user.setFirstName(in.nextLine());
        System.out.println("Enter last name");
        user.setLastName(in.nextLine());
        System.out.println("Enter age");
        user.setAge(in.nextInt());
        System.out.println("Enter email");
        user.setEmail(in.nextLine());
        System.out.println("Enter role");
        user.setRole(User.Role.valueOf((in.nextLine()).toUpperCase()));
        userService.update(user);
    }
}
