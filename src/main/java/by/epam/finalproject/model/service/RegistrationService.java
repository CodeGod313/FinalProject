package by.epam.finalproject.model.service;

import by.epam.finalproject.model.entity.Client;
import by.epam.finalproject.model.exception.DaoException;
import by.epam.finalproject.model.exception.WrongParameterException;

public interface RegistrationService {
    void registerClient(Client client) throws DaoException, WrongParameterException;
}
