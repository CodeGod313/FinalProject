package by.epam.finalproject.model.factory.impl;

import by.epam.finalproject.model.entity.Crypto;
import by.epam.finalproject.model.factory.CryptoFactory;

import java.math.BigDecimal;

public class CryptoFactoryImpl implements CryptoFactory {
    @Override
    public Crypto createCryptoFromStrings(String cryptoName, String cryptoShortName, String cryptoPrice, String cryptoDescription, String cryptoHash, String filePath) {
        BigDecimal price = new BigDecimal(cryptoPrice);
        Crypto crypto = new Crypto(cryptoName, cryptoShortName, cryptoDescription, cryptoHash, filePath, price);
        return crypto;
    }
}
