package by.epam.finalproject.model.service;

import by.epam.finalproject.model.exception.ServiceException;

import java.math.BigDecimal;

public interface CryptoService {
    void sellCoins(Long clientId, Long coinsTypeId, BigDecimal quantity);
    void buyCoins(Long clientId, Long coinsType, BigDecimal quantity);
    void createCrypto(String cryptoName, String cryptoShortName, String cryptoPrice, String cryptoDescription, String cryptoHash, String filePath) throws ServiceException;
}
