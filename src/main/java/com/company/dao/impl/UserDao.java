package com.company.dao.impl;

import com.company.entity.Book;
import com.company.entity.User;

import java.util.List;

public interface UserDao {

    User create(User user);

    User getById(Long id);

    User getUserByEmail(String email);

    List<User> getAll();

    List<User> getUserByLastName(String lastName);

    Long countAllUsers();

    User update(User user);

    boolean delete(Long id);


}
