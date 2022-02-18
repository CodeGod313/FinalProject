package by.epam.finalproject.model.service;

import by.epam.finalproject.model.exception.ServiceException;

public interface MailService {
    void sendAccountVerificationEmail(String emailAddress, String verificationId) throws ServiceException;
}
