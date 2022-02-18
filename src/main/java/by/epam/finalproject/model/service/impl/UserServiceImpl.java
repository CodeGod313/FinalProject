package by.epam.finalproject.model.service.impl;

import by.epam.finalproject.model.dao.UserDao;
import by.epam.finalproject.model.dao.impl.UserDaoImpl;
import by.epam.finalproject.model.dbconnection.ConnectionPool;
import by.epam.finalproject.model.dbconnection.impl.ConnectionPoolImpl;
import by.epam.finalproject.model.entity.User;
import by.epam.finalproject.model.exception.DaoException;
import by.epam.finalproject.model.exception.ServiceException;
import by.epam.finalproject.model.service.EncryptionService;
import by.epam.finalproject.model.service.UserService;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Override
    public Optional<User> logIn(String email, String password) throws ServiceException {
        EncryptionService encryptionService = new EncryptionServiceImpl();
        String encryptedPassword = encryptionService.encryptPassword(password);
        ConnectionPool connectionPool = ConnectionPoolImpl.getInstance();
        Connection connection = connectionPool.getConnection();
        UserDao userDao = new UserDaoImpl();
        userDao.setConnection(connection);
        Optional<User> user = Optional.empty();
        try {
            user = userDao.getUserByEmailAndPassword(email, encryptedPassword);
            connection.close();
        } catch (SQLException e) {
            logger.error("Can not close connection", e);
            throw new ServiceException("Can not close connection", e);
        } catch (DaoException e) {
            logger.error("Can not get user", e);
            throw new ServiceException("Can not get user", e);
        }
        return user;
    }
}
