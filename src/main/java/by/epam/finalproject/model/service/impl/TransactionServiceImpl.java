package by.epam.finalproject.model.service.impl;

import by.epam.finalproject.model.dao.Dao;
import by.epam.finalproject.model.dbconnection.ConnectionPool;
import by.epam.finalproject.model.dbconnection.impl.ConnectionPoolImpl;
import by.epam.finalproject.model.exception.WrongParameterException;
import by.epam.finalproject.model.service.TransactionService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionServiceImpl implements TransactionService {
    static Logger logger = LogManager.getLogger(TransactionServiceImpl.class);
    Connection connection;

    @Override
    public void begin(Dao dao, Dao... daos) {
        if (connection == null) {
            ConnectionPool connectionPool = ConnectionPoolImpl.getInstance();
            connection = connectionPool.getConnection();
        }
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            logger.error("Can not set auto commit to false");
        }
        dao.setConnection(connection);
        for (Dao daoElement : daos) {
            daoElement.setConnection(connection);
        }
    }

    @Override
    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            logger.error("Can not commit transaction", e);
        }
    }

    @Override
    public void end() throws WrongParameterException {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            logger.error("Can not set auto commit to false", e);
        }
        ConnectionPool connectionPool = ConnectionPoolImpl.getInstance();
        connectionPool.releaseConnection(connection);
        connection = null;
    }


    @Override
    public void close() throws Exception {
        end();
    }
}
