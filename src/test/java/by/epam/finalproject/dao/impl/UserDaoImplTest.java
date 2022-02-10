package by.epam.finalproject.dao.impl;

import by.epam.finalproject.model.dao.Dao;
import by.epam.finalproject.model.dao.impl.UserDaoImpl;
import by.epam.finalproject.model.entity.User;
import by.epam.finalproject.model.exception.DaoException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserDaoImplTest {

    Dao<User> userDao;

    @BeforeAll
    void setUp() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
        ResourceBundle databaseBundle = ResourceBundle.getBundle("database");
        String databaseUrl = databaseBundle.getString("db.url");
        String databaseUser = databaseBundle.getString("db.user");
        String databasePassword = databaseBundle.getString("db.password");
        Connection connection = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);
        userDao = new UserDaoImpl();
        userDao.setConnection(connection);
    }


    @Test
    void create() throws DaoException {
        User user = new User("Violetta", "Ban", "kakaka@gmail.com", "popa", "client");
        userDao.create(user);
    }
}