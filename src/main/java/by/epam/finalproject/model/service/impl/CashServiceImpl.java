package by.epam.finalproject.model.service.impl;

import by.epam.finalproject.model.dao.AccountDao;
import by.epam.finalproject.model.dao.impl.AccountDaoImpl;
import by.epam.finalproject.model.dbconnection.ConnectionPool;
import by.epam.finalproject.model.dbconnection.impl.ConnectionPoolImpl;
import by.epam.finalproject.model.entity.Account;
import by.epam.finalproject.model.exception.DaoException;
import by.epam.finalproject.model.exception.WrongParameterException;
import by.epam.finalproject.model.service.CashService;
import by.epam.finalproject.model.service.TransactionService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Optional;

public class CashServiceImpl implements CashService {
    static Logger logger = LogManager.getLogger(CashServiceImpl.class);

    @Override
    public void topUp(Long clientId, BigDecimal value) throws WrongParameterException, DaoException {
        if (value.compareTo(new BigDecimal(0)) <= 0 || clientId <=0) {
            logger.error("Parameters are wrong");
            throw new WrongParameterException("Parameters are wrong");
        }
        AccountDao accountDao = new AccountDaoImpl();
        ConnectionPool connectionPool = ConnectionPoolImpl.getInstance();
        Connection connection = connectionPool.getConnection();
        accountDao.setConnection(connection);
        Optional<Account> optionalAccount = accountDao.getAccountByClientId(clientId);
        if(!optionalAccount.isPresent()){
            logger.error("Client with id = " + clientId + "does not exist");
            throw new WrongParameterException("Client with id = " + clientId + "does not exist");
        }
        Account account = optionalAccount.get();
        account.setValue(account.getValue().add(value));
        accountDao.update(account);
    }
}
