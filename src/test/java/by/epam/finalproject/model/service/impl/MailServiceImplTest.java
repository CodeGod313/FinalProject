package by.epam.finalproject.model.service.impl;

import by.epam.finalproject.model.exception.ServiceException;
import by.epam.finalproject.model.service.MailService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MailServiceImplTest {

    MailService mailService;

    @BeforeAll
    void setUp() throws ServiceException {
        mailService = new MailServiceImpl();
    }

    @Test
    void sendAccountVerificationEmail() throws ServiceException {
        mailService.sendAccountVerificationEmail("violkarout@gmail.com", "love❤");
    }
}