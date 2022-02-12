package by.epam.finalproject.model.service;

import by.epam.finalproject.model.exception.WrongParameterException;

public interface SharesService {
    boolean buyShares(Integer quantity, Long clientId, Long companyId) throws WrongParameterException;
    boolean sellShares(Integer quantity, Long clientId, Long companyId) throws WrongParameterException;
}
