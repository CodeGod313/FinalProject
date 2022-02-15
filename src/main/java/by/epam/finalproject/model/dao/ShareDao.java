package by.epam.finalproject.model.dao;

import by.epam.finalproject.model.entity.Share;
import by.epam.finalproject.model.exception.DaoException;

import java.util.Optional;

public interface ShareDao extends Dao<Share>{
    Optional<Share> getByClientIdAndCompanyId(Long clientId, Long companyId) throws DaoException;
}
