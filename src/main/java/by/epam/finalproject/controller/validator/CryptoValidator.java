package by.epam.finalproject.controller.validator;

public interface CryptoValidator {
    boolean validateCryptoParameters(String cryptoName, String cryptoShortName, String cryptoPrice, String cryptoDescription, String cryptoHash);
    boolean isPossibleName(String cryptoName);
}
