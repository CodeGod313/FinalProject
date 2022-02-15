package by.epam.finalproject.model.service.impl;

import by.epam.finalproject.model.dao.CoinTypeDao;
import by.epam.finalproject.model.dao.impl.CoinTypeDaoImpl;
import by.epam.finalproject.model.service.CryptoService;
import by.epam.finalproject.model.service.TransactionService;

import java.math.BigDecimal;

public class CryptoServiceImpl implements CryptoService {
    @Override
    public void sellCoins(Long clientId, Long coinsTypeId, BigDecimal quantity) {

    }

    @Override
    public void buyCoins(Long clientId, Long coinsType, BigDecimal quantity) {
        try(TransactionService transactionService = new TransactionServiceImpl()) {
            CoinTypeDao coinTypeDao = new CoinTypeDaoImpl();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
