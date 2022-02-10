package by.epam.finalproject.model.dao.impl;

import by.epam.finalproject.model.dao.Dao;
import by.epam.finalproject.model.entity.Client;
import by.epam.finalproject.model.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class ClientDaoImpl implements Dao<Client> {
    static Logger logger = LogManager.getLogger(ClientDaoImpl.class);
    public static final String INSERT_USER_COMMAND = "INSERT INTO users(first_name, last_name, email, user_password, role_id) VALUES(?, ?, ?, ?, (SELECT role_id FROM roles WHERE roles.role_name = 'client')); INSERT INTO clients(user_id, passport_series, passport_number) VALUES ((SELECT user_id FROM users WHERE users.email = ?), ?, ?);";
    private Connection connection;

    @Override
    public Optional<Client> getById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public void create(Client entity) throws DaoException {
        if (connection == null) {
            throw new DaoException("Connection is null");
        }
        try (PreparedStatement statement = connection.prepareStatement(INSERT_USER_COMMAND)) {
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getEmail());
            statement.setString(4, entity.getPassword());
            statement.setString(5, entity.getEmail());
            statement.setString(6, entity.getPassport_series());
            statement.setString(7, entity.getPassport_number());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can not create user", e);
            throw new DaoException("Can not create client", e);
        }
    }

    @Override
    public void update(Client entity) throws DaoException {

    }

    @Override
    public void delete(Client entity) throws DaoException {

    }

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
