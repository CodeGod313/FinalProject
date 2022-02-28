package by.epam.finalproject.model.dao;

import by.epam.finalproject.model.entity.Crypto;
import by.epam.finalproject.model.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface CryptoDao extends Dao<Crypto>{
    Optional<Crypto> getByName(String cryptoName) throws DaoException;
    List<Crypto> getAll() throws DaoException;
}
