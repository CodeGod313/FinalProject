package by.epam.finalproject.model.dao.impl;

import by.epam.finalproject.model.dao.CryptoDao;
import by.epam.finalproject.model.entity.Crypto;
import by.epam.finalproject.model.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CryptoDaoImpl implements CryptoDao {
    public static final String GET_CRYPTO_BY_NAME_QUERY = "SELECT crypto_id, short_name, description, crypto_hash, price, image_path FROM cryptos WHERE crypto_name = ?";
    public static final String CRYPTO_ID_COLUMN = "crypto_id";
    public static final String SHORT_NAME_COLUMN = "short_name";
    public static final String DESCRIPTION_COLUMN = "description";
    public static final String CRYPTO_HASH_COLUMN = "crypto_hash";
    public static final String PRICE_COLUMN = "price";
    public static final String IMAGE_PATH_COLUMN = "image_path";
    public static final String GET_ALL_CRYPTOS_QUERY = "SELECT crypto_id, crypto_name, short_name, description, crypto_hash, price, image_path FROM cryptos";
    public static final String CRYPTO_NAME_COLUMN = "crypto_name";
    Connection connection;
    static Logger logger = LogManager.getLogger(CryptoDaoImpl.class);

    @Override
    public Optional<Crypto> getById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public void create(Crypto entity) throws DaoException {

    }

    @Override
    public void update(Crypto entity) throws DaoException {

    }

    @Override
    public void delete(Long id) throws DaoException {

    }

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Crypto> getByName(String cryptoName) throws DaoException {
        if (connection == null) {
            throw new DaoException("Connection is null");
        }
        Optional<Crypto> crypto = Optional.empty();
        try (PreparedStatement statement = connection.prepareStatement(GET_CRYPTO_BY_NAME_QUERY)) {
            statement.setString(1, cryptoName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long id = resultSet.getLong(CRYPTO_ID_COLUMN);
                String shortName = resultSet.getString(SHORT_NAME_COLUMN);
                String description = resultSet.getString(DESCRIPTION_COLUMN);
                String cryptoHash = resultSet.getString(CRYPTO_HASH_COLUMN);
                BigDecimal price = resultSet.getBigDecimal(PRICE_COLUMN);
                String imagePath = resultSet.getString(IMAGE_PATH_COLUMN);
                crypto = Optional.of(new Crypto(id, cryptoName, shortName, description, cryptoHash, price, imagePath));
            }
        } catch (SQLException e) {
            logger.error("Can not get crypto by name", e);
            throw new DaoException("Can not get crypto by name", e);
        }
        return crypto;
    }

    @Override
    public List<Crypto> getAll() throws DaoException {
        if (connection == null) {
            throw new DaoException("Connection is null");
        }
        List<Crypto> cryptos = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_CRYPTOS_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong(CRYPTO_ID_COLUMN);
                String cryptoName = resultSet.getString(CRYPTO_NAME_COLUMN);
                String shortName = resultSet.getString(SHORT_NAME_COLUMN);
                String description = resultSet.getString(DESCRIPTION_COLUMN);
                String cryptoHash = resultSet.getString(CRYPTO_HASH_COLUMN);
                BigDecimal price = resultSet.getBigDecimal(PRICE_COLUMN);
                String imagePath = resultSet.getString(IMAGE_PATH_COLUMN);
                Crypto crypto = new Crypto(id, cryptoName, shortName, description, cryptoHash, price, imagePath);
                cryptos.add(crypto);
            }
        } catch (SQLException e) {
            logger.error("Can not get cryptos", e);
            throw new DaoException("Can not get crypto", e);
        }
        return cryptos;
    }
}
