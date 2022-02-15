package by.epam.finalproject.model.dao;

import by.epam.finalproject.model.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public interface Dao<T> {
    static Logger logger = LogManager.getLogger(Dao.class);
    Optional<T> getById(Long id) throws DaoException;
    void create(T entity) throws DaoException;
    void update(T entity) throws DaoException;
    void delete(Long id) throws DaoException;
    void setConnection(Connection connection);
}
