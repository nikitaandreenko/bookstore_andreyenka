package com.company.service;

import com.company.entity.User;

import java.util.List;

public interface UserService {
    User create(User user);

    User getById(Long id);

    User getUserByEmail(String email);

    List<User> getAll();

    List<User> getUserByLastName(String lastName);

    Long countAllUsers();

    User update(User user);

    void delete(Long id);
}
