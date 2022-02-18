package by.epam.finalproject.model.service;

import by.epam.finalproject.model.entity.User;
import by.epam.finalproject.model.exception.ServiceException;

import java.util.Optional;

public interface UserService {
    Optional<User> logIn(String email, String password) throws ServiceException;
}
