package com.company.service;

import com.company.dao.BookDaoImpl;
import com.company.dao.UserDaoImpl;
import com.company.entity.Book;
import com.company.entity.User;

import java.math.BigDecimal;
import java.util.List;

public class UserService {
    private final UserDaoImpl userDao;

    public UserService(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public User create(User user) {
        return userDao.create(user);
    }

    public User getById(Long id) {
        User user = userDao.getById(id);
        if (user == null) {
            throw new RuntimeException("User with id:" + id + " doesn't exist");
        }
        return user;
    }

    public User getUserByEmail(String email) {
        User user = userDao.getUserByEmail(email);
        if (user == null) {
            throw new RuntimeException("User with email:" + email + " doesn't exist");
        }
        return user;
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public List<User> getUserByLastName(String lastName) {
        List<User> users = userDao.getUserByLastName(lastName);
        if (users == null) {
            throw new RuntimeException("Users with lastname: " + lastName + " don't exist");
        }
        return users;
    }

    public int countAllUsers() {
        return userDao.countAllUsers();
    }

    public User update(User user) {
        User user1 = userDao.update(user);
        if (user1 == null) {
            throw new RuntimeException("Users can't be empty...");
        }
        return user1;
    }

    public void delete(Long id) {
        boolean successRemove = userDao.delete(id);
        if (!successRemove) {
            throw new RuntimeException("This user doesn't remove");
        }
    }
}
