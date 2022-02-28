package by.epam.finalproject.model.dao;

import by.epam.finalproject.model.entity.Company;
import by.epam.finalproject.model.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface CompanyDao extends Dao<Company> {
    Optional<Company> getByName(String companyName) throws DaoException;
    List<Company> getAll() throws DaoException;
}
