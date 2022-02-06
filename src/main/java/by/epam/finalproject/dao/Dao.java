package by.epam.finalproject.dao;

import by.epam.finalproject.exception.DaoException;

import java.sql.Connection;

public interface Dao<T> {
    T getById(Long id) throws DaoException;
    void create(T entity) throws DaoException;
    void update(T entity) throws DaoException;
    void delete(T entity) throws DaoException;
    void setConnection(Connection connection);
}
