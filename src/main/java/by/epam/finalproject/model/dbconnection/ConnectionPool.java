package by.epam.finalproject.model.dbconnection;

import by.epam.finalproject.model.exception.WrongParameterException;

import java.sql.Connection;

public interface ConnectionPool {
    Connection getConnection();
    void releaseConnection(Connection connection) throws WrongParameterException;
    void destroyAllConnections();
}
