package by.epam.finalproject.model.service.impl;

import by.epam.finalproject.model.dao.Dao;
import by.epam.finalproject.model.dao.impl.ClientDaoImpl;
import by.epam.finalproject.model.dbconnection.ConnectionPool;
import by.epam.finalproject.model.dbconnection.impl.ConnectionPoolImpl;
import by.epam.finalproject.model.entity.Client;
import by.epam.finalproject.model.exception.DaoException;
import by.epam.finalproject.model.exception.WrongParameterException;
import by.epam.finalproject.model.service.EncryptionService;
import by.epam.finalproject.model.service.RegistrationService;
import by.epam.finalproject.model.validator.ClientValidator;
import by.epam.finalproject.model.validator.impl.ClientValidatorImpl;

import java.sql.Connection;

public class RegistrationServiceImpl implements RegistrationService {
    @Override
    public void registerClient(Client client) throws DaoException, WrongParameterException {
        ClientValidator clientValidator = new ClientValidatorImpl();
        if(!clientValidator.validate(client)){
            throw new WrongParameterException("User fields fields do not match requirements");
        }
        String password = client.getPassword();
        EncryptionService encryptionService = new EncryptionServiceImpl();
        String encryptedPassword = encryptionService.encryptPassword(password);
        client.setPassword(encryptedPassword);
        Dao<Client> clientDao = new ClientDaoImpl();
        ConnectionPool connectionPool = ConnectionPoolImpl.getInstance();
        Connection connection = connectionPool.getConnection();
        clientDao.setConnection(connection);
        clientDao.create(client);
    }
}
