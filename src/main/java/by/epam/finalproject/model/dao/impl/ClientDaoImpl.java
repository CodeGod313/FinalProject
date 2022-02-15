package by.epam.finalproject.model.dao.impl;

import by.epam.finalproject.model.dao.ClientDao;
import by.epam.finalproject.model.entity.Client;
import by.epam.finalproject.model.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class ClientDaoImpl implements ClientDao {
    private static final String UPDATE_client_QUERY = "UPDATE clients SET passport_series = ?, passport_number = ? WHERE client_id = 1;\n" +
            "UPDATE users SET first_name = ?, last_name = ?, email = ? WHERE user_id = (SELECT user_id FROM clients WHERE client_id = ?)";
    private static final String UPDATE_CLIENT_PASSWORD_QUERY = "UPDATE users SET user_password = ? WHERE user_id = (SELECT user_id FROM clients WHERE client_id = ?)";
    private Logger logger = LogManager.getLogger(ClientDaoImpl.class);
    private static final String INSERT_USER_COMMAND = "INSERT INTO users(first_name, last_name, email, user_password, role_id) VALUES(?, ?, ?, ?, (SELECT role_id FROM roles WHERE roles.role_name = 'client')); INSERT INTO clients(user_id, passport_series, passport_number) VALUES ((SELECT user_id FROM users WHERE users.email = ?), ?, ?);";
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
        if (connection == null) {
            throw new DaoException("Connection is null");
        }
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_client_QUERY)) {
            statement.setString(1, entity.getPassport_series());
            statement.setString(2, entity.getPassport_number());
            statement.setLong(3, entity.getId());
            statement.setString(4, entity.getFirstName());
            statement.setString(5, entity.getLastName());
            statement.setLong(6, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can not update client");
            throw new DaoException("Can not update client");
        }
    }

    @Override
    public void delete(Long id) throws DaoException {

    }

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void updatePassword(Long clientId, String renewedPassword) throws DaoException {
        if (connection == null) {
            throw new DaoException("Connection is null");
        }
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_CLIENT_PASSWORD_QUERY)) {
            statement.setString(1, renewedPassword);
            statement.setLong(2, clientId);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can not update password");
            throw new DaoException("Can not update password");
        }
    }
}
