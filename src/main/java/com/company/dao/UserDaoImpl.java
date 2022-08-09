package com.company.dao;

import com.company.dao.connection.DateSourсe;
import com.company.dao.impl.UserDao;
import com.company.entity.User;
import com.company.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final Logger log = LogManager.getLogger(UserService.class);

    public static final String GET_ALL = "SELECT users.id, users.first_name, users.last_name, users.age, users.email, roles.name " +
            "FROM users JOIN roles ON role_id = roles.id";
    public static final String GET_BY_ID = "SELECT users.id, users.first_name, users.last_name, users.age, users.email, roles.name " +
            "FROM users JOIN roles ON role_id = roles.id WHERE users.id = ?";

    public static final String CREATE_USER = "INSERT INTO users (first_name, last_name, age, email, role_id) " +
            "VALUES (?, ?, ?, ?, (SELECT id FROM roles WHERE name = ?))";

    public static final String GET_BY_EMAIL = "SELECT users.id, users.first_name, users.last_name, users.age, users.email, roles.name " +
            "FROM users JOIN roles ON role_id = roles.id WHERE users.email = ?";
    public static final String UPDATE_USER = "UPDATE users SET first_name=?, last_name=?, age=?, email=?, " +
            "role_id = (SELECT id FROM roles WHERE name = ?) WHERE id=?";
    public static final String GET_ALL_LASTNAME = "SELECT users.id, users.first_name, users.last_name, users.age, users.email, roles.name " +
            "FROM users JOIN roles ON role_id = roles.id WHERE users.last_name= ?";
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
        log.debug("Create user={} database users", user);
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
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public User getById(Long id) {
        log.debug("Get user by id={} from database users", id);
        Connection connection = dateSourсe.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(GET_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return process(resultSet);
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        log.debug("Get user by email={} from database users", email);
        Connection connection = dateSourсe.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(GET_BY_EMAIL)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = process(resultSet);
                return user;
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        log.debug("Get all users from database users");
        List<User> users = new ArrayList<>();
        Connection connection = dateSourсe.getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                User user = process(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return users;
    }

    @Override
    public List<User> getUserByLastName(String lastName) {
        log.debug("Get user by LastName={} from database users", lastName);
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
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Long countAllUsers() {
        log.debug("Count all users from database users");
        Connection connection = dateSourсe.getConnection();
        try (Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery("SELECT count(*) AS total FROM users");
            if (resultSet.next()) {
                return resultSet.getLong("total");
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        throw new RuntimeException("Exception");
    }

    @Override
    public User update(User user) {
        log.debug("Update user={} in database users", user);
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
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        log.debug("Delete user by id={} in database users", id);
        Connection connection = dateSourсe.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setLong(1, getById(id).getId());
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }
}
