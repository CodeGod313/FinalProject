package by.epam.finalproject.dbconnection;

import by.epam.finalproject.exception.WrongParameterException;

import java.sql.Connection;

public interface ConnectionPool {
    Connection getConnection();
    void releaseConnection(Connection connection) throws WrongParameterException;
    void destroyAllConnections();
}
