package by.epam.finalproject.model.dao.impl;

import by.epam.finalproject.model.dao.CoinTypeDao;
import by.epam.finalproject.model.entity.CoinType;
import by.epam.finalproject.model.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CoinTypeDaoImpl implements CoinTypeDao {
    public static final String GET_TYPE_BY_ID_QUERY = "SELECT coin_name, short_name, description, coin_function, price FROM coin_types WHERE coin_type_id = ?";
    public static final String PRICE_COLUMN = "price";
    public static final String COIN_FUNCTION_COLUMN = "coin_function";
    public static final String DESCRIPTION_COLUMN = "description";
    public static final String SHORT_NAME_COLUMN = "short_name";
    public static final String COIN_NAME_COLUMN = "coin_name";
    Connection connection;
    static Logger logger = LogManager.getLogger(CoinTypeDaoImpl.class);

    @Override
    public Optional<CoinType> getById(Long id) throws DaoException {
        if (connection == null) {
            throw new DaoException("Connection is null");
        }
        Optional<CoinType> coinType = Optional.empty();
        try (PreparedStatement statement = connection.prepareStatement(GET_TYPE_BY_ID_QUERY)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String coinName = resultSet.getString(COIN_NAME_COLUMN);
                String shortName = resultSet.getString(SHORT_NAME_COLUMN);
                String description = resultSet.getString(DESCRIPTION_COLUMN);
                String coinFunction = resultSet.getString(COIN_FUNCTION_COLUMN);
                BigDecimal price = resultSet.getBigDecimal(PRICE_COLUMN);
                coinType = Optional.of(new CoinType(id, coinName, shortName, description, coinFunction, price));
            }
        } catch (SQLException e) {
            logger.error("Can not get coin type");
            throw new DaoException("Can not get coin type");
        }
        return coinType;
    }

    @Override
    public void create(CoinType entity) throws DaoException {

    }

    @Override
    public void update(CoinType entity) throws DaoException {

    }

    @Override
    public void delete(Long id) throws DaoException {

    }

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
