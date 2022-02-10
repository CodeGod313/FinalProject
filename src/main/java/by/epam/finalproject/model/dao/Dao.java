package by.epam.finalproject.model.dao;

import by.epam.finalproject.model.exception.DaoException;

import java.sql.Connection;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> getById(Long id) throws DaoException;
    void create(T entity) throws DaoException;
    void update(T entity) throws DaoException;
    void delete(T entity) throws DaoException;
    void setConnection(Connection connection);
}
