package by.epam.finalproject.controller.validator.impl;

import by.epam.finalproject.controller.validator.CryptoValidator;
import by.epam.finalproject.model.dao.CryptoDao;
import by.epam.finalproject.model.dao.impl.CryptoDaoImpl;
import by.epam.finalproject.model.dbconnection.impl.ConnectionPoolImpl;
import by.epam.finalproject.model.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class CryptoValidatorImpl implements CryptoValidator {
    static Logger logger = LogManager.getLogger(CompanyValidatorImpl.class);
    public static final String REGEX_CRYPTO_NAME = "[A-Z]+[a-z0-9]*";
    public static final String CRYPTO_SHORT_NAME_REGEX = "[A-Z]{3,5}";
    public static final String REGEX_CRYPTO_PRICE = "\\d+";
    public static final String REGEX_CRYPTO_HASH = "[a-zA-Z\\-\\d]{4,10}";

    @Override
    public boolean validateCryptoParameters(String cryptoName, String cryptoShortName, String cryptoPrice, String cryptoDescription, String cryptoHash) {
        return cryptoName != null &&
                cryptoShortName != null &&
                cryptoPrice != null &&
                cryptoDescription != null &&
                cryptoHash != null &&
                cryptoName.matches(REGEX_CRYPTO_NAME) &&
                cryptoShortName.matches(CRYPTO_SHORT_NAME_REGEX) &&
                cryptoPrice.matches(REGEX_CRYPTO_PRICE) &&
                cryptoHash.matches(REGEX_CRYPTO_HASH);
    }

    @Override
    public boolean isPossibleName(String cryptoName) {
        CryptoDao cryptoDao = new CryptoDaoImpl();
        try (Connection connection = ConnectionPoolImpl.getInstance().getConnection()) {
            cryptoDao.setConnection(connection);
            return cryptoDao.getByName(cryptoName).isEmpty();
        } catch (SQLException | DaoException e) {
            logger.error("Connection problems", e);
        }
        return false;
    }
}
