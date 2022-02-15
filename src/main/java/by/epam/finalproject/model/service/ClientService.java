package by.epam.finalproject.model.service;

import by.epam.finalproject.model.entity.Client;
import by.epam.finalproject.model.exception.DaoException;
import by.epam.finalproject.model.exception.WrongParameterException;

public interface ClientService {
    void changeClientDetails(Client client) throws WrongParameterException, DaoException;
    void changePassword(Long clientId, String renewedPassword) throws WrongParameterException, DaoException;
}
