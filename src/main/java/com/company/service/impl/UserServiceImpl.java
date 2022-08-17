package com.company.service.impl;


import com.company.dao.impl.UserDaoImpl;
import com.company.entity.User;
import com.company.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static final Logger log = LogManager.getLogger(UserServiceImpl.class);
    private final UserDaoImpl userDao;

    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public User create(User user) {
        log.debug("Create user={} in database user", user);
        return userDao.create(user);
    }

    @Override
    public User getById(Long id) {
        log.debug("Get user by id={} from database users", id);
        User user = userDao.getById(id);
        if (user == null) {
            throw new RuntimeException("User with id:" + id + " doesn't exist");
        }
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        log.debug("Get user by email={} from database users", email);
        User user = userDao.getUserByEmail(email);
        if (user == null) {
            throw new RuntimeException("User with email:" + email + " doesn't exist");
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        log.debug("Get all users from database users");
        return userDao.getAll();
    }

    @Override
    public List<User> getUserByLastName(String lastName) {
        log.debug("Get user by LastName={} from database users", lastName);
        List<User> users = userDao.getUserByLastName(lastName);
        if (users == null) {
            throw new RuntimeException("Users with lastname: " + lastName + " don't exist");
        }
        return users;
    }

    @Override
    public Long countAllUsers() {
        log.debug("Count all users from database users");
        return userDao.countAllUsers();
    }

    @Override
    public User update(User user) {
        log.debug("Update user={} in database users", user);
        User user1 = userDao.update(user);
        if (user1 == null) {
            throw new RuntimeException("Users can't be empty...");
        }
        return user1;
    }

    @Override
    public void delete(Long id) {
        log.debug("Delete user by id={} in database users", id);
        boolean successRemove = userDao.delete(id);
        if (!successRemove) {
            throw new RuntimeException("This user doesn't remove");
        }
    }
}
