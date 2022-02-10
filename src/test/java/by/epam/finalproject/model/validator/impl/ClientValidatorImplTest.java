package by.epam.finalproject.model.validator.impl;

import by.epam.finalproject.model.entity.Client;
import by.epam.finalproject.model.validator.ClientValidator;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ClientValidatorImplTest {

    ClientValidator clientValidator;
    Client client;


    @BeforeAll
    void setUp(){
        clientValidator = new ClientValidatorImpl();
        client = new Client("Ales", "Shpak", "gshpack@gmail.com", "ooooo222", "MC", "2810555");
    }

    @Test
    void validate() {
        Assertions.assertTrue(clientValidator.validate(client));
    }
}