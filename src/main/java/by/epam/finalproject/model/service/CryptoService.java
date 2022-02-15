package by.epam.finalproject.model.service;

import java.math.BigDecimal;

public interface CryptoService {
    void sellCoins(Long clientId, Long coinsTypeId, BigDecimal quantity);
    void buyCoins(Long clientId, Long coinsType, BigDecimal quantity);
}
