package com.company.dao;

import com.company.entity.Book;
import com.company.entity.User;

import java.util.List;

public interface UserDao {
    //Create
   User create(User user);

    //Read
    User getById(Long id);

    User getUserByEmail(String email);

    List<User> getAll();

    List<User> getUserByLastName(String lastName);

    int countAllUsers();

    //Update
    User update(User user);

    //Delete
    boolean delete(Long id);


}
