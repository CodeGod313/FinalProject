package by.epam.finalproject.model.service.impl;

import by.epam.finalproject.model.dao.CryptoDao;
import by.epam.finalproject.model.dao.impl.CryptoDaoImpl;
import by.epam.finalproject.model.dbconnection.impl.ConnectionPoolImpl;
import by.epam.finalproject.model.entity.Crypto;
import by.epam.finalproject.model.exception.DaoException;
import by.epam.finalproject.model.exception.ServiceException;
import by.epam.finalproject.model.factory.CryptoFactory;
import by.epam.finalproject.model.factory.impl.CryptoFactoryImpl;
import by.epam.finalproject.model.service.CryptoService;
import by.epam.finalproject.model.service.TransactionService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CryptoServiceImpl implements CryptoService {
    static Logger logger = LogManager.getLogger(CryptoServiceImpl.class);

    @Override
    public void sellCoins(Long clientId, Long coinsTypeId, BigDecimal quantity) {

    }

    @Override
    public void buyCoins(Long clientId, Long coinsType, BigDecimal quantity) {
        try (TransactionService transactionService = new TransactionServiceImpl()) {
            CryptoDao cryptoDao = new CryptoDaoImpl();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createCrypto(String cryptoName, String cryptoShortName, String cryptoPrice, String cryptoDescription, String cryptoHash, String filePath) throws ServiceException {
        CryptoFactory cryptoFactory = new CryptoFactoryImpl();
        Crypto crypto = cryptoFactory.createCryptoFromStrings(cryptoName, cryptoShortName, cryptoPrice, cryptoDescription, cryptoHash, filePath);
        CryptoDao cryptoDao = new CryptoDaoImpl();
        try (Connection connection = ConnectionPoolImpl.getInstance().getConnection()) {
            cryptoDao.setConnection(connection);
            cryptoDao.create(crypto);
        } catch (SQLException | DaoException e) {
            logger.error("Can not create crypto", e);
            throw new ServiceException("Can not create crypto", e);
        }
    }

    @Override
    public List<Crypto> findAllCryptos() throws ServiceException {
        List<Crypto> cryptos;
        try (Connection connection = ConnectionPoolImpl.getInstance().getConnection()) {
            CryptoDao cryptoDao = new CryptoDaoImpl();
            cryptoDao.setConnection(connection);
            cryptos = cryptoDao.getAll();
        } catch (SQLException | DaoException e) {
            logger.error("Can not cryptos", e);
            throw new ServiceException("Can not cryptos", e);
        }
        return cryptos;
    }
}
