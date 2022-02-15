package by.epam.finalproject.model.dao.impl;

import by.epam.finalproject.model.dao.AccountDao;
import by.epam.finalproject.model.entity.Account;
import by.epam.finalproject.model.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class AccountDaoImpl implements AccountDao {
    private static final String ACCOUNT_ID_COLUMN = "account_id";
    private static final String ACCOUNT_VALUE_COLUMN = "account_value";
    private static final String ACCOUNT_BY_CLIENT_ID_QUERY = "SELECT account_id, account_value FROM accounts WHERE account_id = ?";
    private static final String UPDATE_ACCOUNT_QUERY = "UPDATE accounts SET account_value = ? WHERE account_id = ?";
    static Logger logger = LogManager.getLogger(AccountDaoImpl.class);
    private Connection connection;

    @Override
    public Optional<Account> getById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public void create(Account entity) throws DaoException {

    }

    @Override
    public void update(Account entity) throws DaoException {
        if (connection == null) {
            throw new DaoException("Connection is null");
        }
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_ACCOUNT_QUERY)) {
            statement.setBigDecimal(1, entity.getValue());
            statement.setLong(2, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can not update account", e);
            throw new DaoException("Can not update account", e);
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
    public Optional<Account> getAccountByClientId(Long clientId) throws DaoException {
        if (connection == null) {
            throw new DaoException("Connection is null");
        }
        Optional<Account> account = Optional.empty();
        try (PreparedStatement statement = connection.prepareStatement(ACCOUNT_BY_CLIENT_ID_QUERY)) {
            statement.setLong(1, clientId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long accountId = resultSet.getLong(ACCOUNT_ID_COLUMN);
                BigDecimal accountValue = resultSet.getBigDecimal(ACCOUNT_VALUE_COLUMN);
                account = Optional.of(new Account(accountId, accountValue));
            }
        } catch (SQLException e) {
            logger.error("Can not get account by client id", e);
            throw new DaoException("Can not get account by client id", e);
        }
        return account;
    }
}
