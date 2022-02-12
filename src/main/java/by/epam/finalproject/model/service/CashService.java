package by.epam.finalproject.model.service;

import by.epam.finalproject.model.exception.DaoException;
import by.epam.finalproject.model.exception.WrongParameterException;

import java.math.BigDecimal;

public interface CashService {
    void topUp(Long clientId, BigDecimal value) throws WrongParameterException, DaoException;
}
