package by.epam.finalproject.model.service.impl;

import by.epam.finalproject.model.service.EncryptionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EncryptionServiceImplTest {

    EncryptionService encryptionService;
    String password;

    @BeforeAll
    void setUp() {
        encryptionService = new EncryptionServiceImpl();
        password = "Gravity";
    }


    @Test
    void encryptPassword() {
        String expected = "fcc576945a34879740cc3930ba8df1b5d957e47d";
        String actual = encryptionService.encryptPassword(password);
        Assertions.assertEquals(expected, actual);
    }
}