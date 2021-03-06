package by.epam.finalproject.model.dbconnection.impl;

import by.epam.finalproject.model.dbconnection.ConnectionPool;
import by.epam.finalproject.model.exception.WrongParameterException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ConnectionPoolImpl implements ConnectionPool {
    public static final int NUMBER_OF_CONNECTIONS = 15;
    static Logger logger = LogManager.getLogger(ConnectionPoolImpl.class);
    private static Lock lock = new ReentrantLock();
    private static ConnectionPoolImpl instance;
    private static AtomicBoolean isCreated = new AtomicBoolean(false);
    private Deque<ProxyConnection> pool;

    private ConnectionPoolImpl() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            ResourceBundle databaseBundle = ResourceBundle.getBundle("database");
            String databaseUrl = databaseBundle.getString("db.url");
            String databaseUser = databaseBundle.getString("db.user");
            String databasePassword = databaseBundle.getString("db.password");
            pool = new ArrayDeque<>();
            for (int i = 0; i < NUMBER_OF_CONNECTIONS; i++) {
                Connection connection = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);
                ProxyConnection proxyConnection = new ProxyConnection(connection);
                pool.push(proxyConnection);
            }
        } catch (SQLException e) {
            logger.error("Database connection error", e);
            throw new RuntimeException("Database connection error", e);
        }

    }

    public static ConnectionPoolImpl getInstance() {
        if (!isCreated.get()) {
            lock.lock();
            try {
                if (!isCreated.get()) {
                    instance = new ConnectionPoolImpl();
                    isCreated.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    @Override
    public Connection getConnection() {
        return pool.pop();
    }

    @Override
    public void releaseConnection(Connection connection) throws WrongParameterException {
        if (!(connection instanceof ProxyConnection)) {
            throw new WrongParameterException("Wrong connection passed to connection pool");
        }
        pool.push((ProxyConnection) connection);
    }

    @Override
    public void destroyAllConnections() {
        pool.forEach(ProxyConnection::realClose);
    }
}
