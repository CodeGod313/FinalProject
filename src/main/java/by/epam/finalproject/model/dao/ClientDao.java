package by.epam.finalproject.model.dao;

import by.epam.finalproject.model.entity.Client;
import by.epam.finalproject.model.exception.DaoException;

public interface ClientDao extends Dao<Client>{
    void updatePassword(Long clientId, String renewedPassword) throws DaoException;
}
