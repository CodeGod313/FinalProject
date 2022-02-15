package by.epam.finalproject.model.service.impl;

import by.epam.finalproject.model.dao.ClientDao;
import by.epam.finalproject.model.dao.Dao;
import by.epam.finalproject.model.dao.impl.ClientDaoImpl;
import by.epam.finalproject.model.entity.Client;
import by.epam.finalproject.model.exception.DaoException;
import by.epam.finalproject.model.exception.WrongParameterException;
import by.epam.finalproject.model.service.ClientService;
import by.epam.finalproject.model.service.EncryptionService;
import by.epam.finalproject.model.validator.ClientValidator;
import by.epam.finalproject.model.validator.impl.ClientValidatorImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ClientServiceImpl implements ClientService {
    static Logger logger = LogManager.getLogger(ClientServiceImpl.class);

    @Override
    public void changeClientDetails(Client client) throws WrongParameterException, DaoException {
        ClientValidator clientValidator = new ClientValidatorImpl();
        if (!clientValidator.validate(client) || client.getId() == null) {
            logger.error("Wrong client fields");
            throw new WrongParameterException("Wrong client fields");
        }
        Dao<Client> clientDao = new ClientDaoImpl();
        clientDao.update(client);
    }

    @Override
    public void changePassword(Long clientId, String renewedPassword) throws WrongParameterException, DaoException {
        ClientValidator clientValidator = new ClientValidatorImpl();
        if (clientId == null || !clientValidator.validatePassword(renewedPassword)) {
            logger.error("Wrong parameters");
            throw new WrongParameterException("Wrong parameters");
        }
        EncryptionService encryptionService = new EncryptionServiceImpl();
        String encryptedPassword = encryptionService.encryptPassword(renewedPassword);
        ClientDao clientDao = new ClientDaoImpl();
        clientDao.updatePassword(clientId, renewedPassword);
    }
}
