package by.epam.finalproject.model.dao;

import by.epam.finalproject.model.entity.User;
import by.epam.finalproject.model.exception.DaoException;

import java.util.Optional;

public interface UserDao extends Dao<User>{
    Optional<User> getUserByEmailAndPassword(String email, String password) throws DaoException;
}
