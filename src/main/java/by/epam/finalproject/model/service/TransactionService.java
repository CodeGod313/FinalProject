package by.epam.finalproject.model.service;

import by.epam.finalproject.model.dao.Dao;
import by.epam.finalproject.model.exception.WrongParameterException;

public interface TransactionService extends AutoCloseable {
    void begin(Dao dao, Dao ... daos);
    void commit();
    void end() throws WrongParameterException;
}
