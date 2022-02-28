package by.epam.finalproject.model.factory;

import by.epam.finalproject.model.entity.Crypto;

public interface CryptoFactory {
    Crypto createCryptoFromStrings(String cryptoName, String cryptoShortName, String cryptoPrice, String cryptoDescription, String cryptoHash, String filePath);
}
