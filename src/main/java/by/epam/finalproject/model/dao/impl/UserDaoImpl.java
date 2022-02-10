package by.epam.finalproject.model.dao.impl;


import by.epam.finalproject.model.dao.Dao;
import by.epam.finalproject.model.dbconnection.ConnectionPool;
import by.epam.finalproject.model.dbconnection.impl.ConnectionPoolImpl;
import by.epam.finalproject.model.entity.User;
import by.epam.finalproject.model.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDaoImpl implements Dao<User> {
    public static final String USER_UPDATE_COMMAND = "UPDATE users SET first_name = ?, last_name = ?, email = ?, user_password =?, role_id = (SELECT role_id FROM roles WHERE role_name = ?) WHERE user_id = ?";
    public static final String USER_DELETE_COMMAND = "DELETE FROM users WHERE user_id = ?";
    public static final String FIRST_NAME_COLUMN = "first_name";
    public static final String LAST_NAME_COLUMN = "last_name";
    public static final String EMAIL_COLUMN = "email";
    public static final String USER_PASSWORD_COLUMN = "user_password";
    public static final String ROLE_NAME_COLUMN = "role_name";
    static Logger logger = LogManager.getLogger(UserDaoImpl.class);
    public static final String USER_ADDING_COMMAND = "INSERT INTO users(first_name, last_name, email, user_password, role_id) values(?, ?, ?, ?, (SELECT role_id FROM roles WHERE role_name=?))";
    Connection connection;

    @Override
    public Optional<User> getById(Long id) throws DaoException {
        if (connection == null) {
            throw new DaoException("Connection is null");
        }
        Optional<User> user;
        try (PreparedStatement statement = connection.prepareStatement("SELECT first_name, last_name, email, user_password, (SELECT role_name FROM roles WHERE users.role_id = roles.role_id) FROM users WHERE user_id = ?")) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            String firstName = resultSet.getString(FIRST_NAME_COLUMN);
            String lastname = resultSet.getString(LAST_NAME_COLUMN);
            String email = resultSet.getString(EMAIL_COLUMN);
            String password = resultSet.getString(USER_PASSWORD_COLUMN);
            String role = resultSet.getString(ROLE_NAME_COLUMN);
            user = Optional.of(new User(id, firstName, lastname, email, password, role));
        } catch (SQLException e) {
            logger.error("Can not get user", e);
            throw new DaoException("Can not get user", e);
        }
        return user;
    }

    @Override
    public void create(User entity) throws DaoException {
        if (connection == null) {
            throw new DaoException("Connection is null");
        }
        try (PreparedStatement statement = connection.prepareStatement(USER_ADDING_COMMAND)) {
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getEmail());
            statement.setString(4, entity.getPassword());
            statement.setString(5, entity.getRole());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can not add user", e);
            throw new DaoException("Can not add user", e);
        }
    }

    @Override
    public void update(User entity) throws DaoException {
        if (connection == null) {
            throw new DaoException("Connection is null");
        }
        try (PreparedStatement statement = connection.prepareStatement(USER_UPDATE_COMMAND)) {
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getEmail());
            statement.setString(4, entity.getPassword());
            statement.setString(5, entity.getRole());
            statement.setLong(6, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can not update user", e);
            throw new DaoException("Can not update user", e);
        }
    }

    @Override
    public void delete(User entity) throws DaoException {
        if (connection == null) {
            throw new DaoException("Connection is null");
        }
        try (PreparedStatement statement = connection.prepareStatement(USER_DELETE_COMMAND)) {
            statement.setLong(1, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can not delete user", e);
            throw new DaoException("Can not delete user", e);
        }
    }
    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
