package by.epam.finalproject.model.service.impl;

import by.epam.finalproject.model.service.EncryptionService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionServiceImpl implements EncryptionService {

    public static final String ENCRYPTION_ALGORITHM = "SHA-1";

    @Override
    public String encryptPassword(String password) {
        StringBuilder encryptedPassword = new StringBuilder();
        try {
            MessageDigest digest = MessageDigest.getInstance(ENCRYPTION_ALGORITHM);
            byte[] passwordBytes = digest.digest(password.getBytes());
            int counter = 0;
            for (byte b : passwordBytes) {
                encryptedPassword.append(String.format("%x", b));
                counter++;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encryptedPassword.toString();
    }
}
