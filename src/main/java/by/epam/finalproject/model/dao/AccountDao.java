package by.epam.finalproject.model.dao;

import by.epam.finalproject.model.entity.Account;
import by.epam.finalproject.model.exception.DaoException;

import java.util.Optional;

public interface AccountDao extends Dao<Account>{
    Optional<Account> getAccountByClientId(Long clientId) throws DaoException;
}
