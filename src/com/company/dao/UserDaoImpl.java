package com.company.dao;

import com.company.entity.Book;
import com.company.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    public static final String GET_ALL = "SELECT users.id, users.first_name, users.last_name, users.age, users.email, roles.name " +
            "FROM users JOIN roles ON role_id = roles.id";
    public static final String GET_BY_ID = "SELECT users.id, users.first_name, users.last_name, users.age, users.email, roles.name " +
            "FROM users JOIN roles ON role_id = roles.id WHERE books.id = ?";

    public static final String CREATE_USER = "INSERT INTO users (first_name, last_name, age, email, role_id) " +
            "VALUES (?, ?, ?, ?, (SELECT id FROM roles WHERE name = ?))";

    public static final String GET_BY_EMAIL = "SELECT users.id, users.first_name, users.last_name, users.age, users.email, roles.name " +
            "FROM users JOIN roles ON role_id = roles.id WHERE books.email = ?";
    public static final String UPDATE_USER = "UPDATE users SET first_name=?, last_name=?, age=?, email=?, " +
            "role_id = (SELECT id FROM roles WHERE name = ?) WHERE id=?";
    public static final String GET_ALL_LASTNAME = "SELECT users.id, users.first_name, users.last_name, users.age, users.email, roles.name " +
            "FROM users JOIN roles ON role_id = roles.id WHERE books.last_name= ?";
    public static final String DELETE_BY_ID = "DELETE FROM users WHERE id=?";


    private final DateSourсe dateSourсe;

    public UserDaoImpl(DateSourсe dateSourсe) {
        this.dateSourсe = dateSourсe;
    }

    private User process(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setAge(resultSet.getInt("age"));
        user.setEmail(resultSet.getString("email"));
        user.setRole(User.Role.valueOf(resultSet.getString("name")));
        return user;
    }

    @Override
    public User create(User user) {
        Connection connection = dateSourсe.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE_USER)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getRole().toString());
            if (statement.executeUpdate() == 1) {
                return getUserByEmail(user.getEmail());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getById(Long id) {
        Connection connection = dateSourсe.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(GET_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return process(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        Connection connection = dateSourсe.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(GET_BY_EMAIL)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = process(resultSet);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        Connection connection = dateSourсe.getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                User user = process(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> getUserByLastName(String lastName) {
        List<User> users = new ArrayList<>();
        Connection connection = dateSourсe.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_LASTNAME)) {
            statement.setString(1, lastName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = process(resultSet);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int countAllUsers() {
        Connection connection = dateSourсe.getConnection();
        try (Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery("SELECT count(*) AS total FROM users");
            if (resultSet.next()) {
                return resultSet.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Exception");
    }

    @Override
    public User update(User user) {
        Connection connection = dateSourсe.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_USER)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getRole().toString());
            statement.setLong(6, user.getId());
            if (statement.executeUpdate() == 1) {
                return getById(user.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Connection connection = dateSourсe.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setLong(1, getById(id).getId());
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
