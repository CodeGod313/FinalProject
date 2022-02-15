package by.epam.finalproject.model.validator;

import by.epam.finalproject.model.entity.Client;

public interface ClientValidator {
    boolean validate(Client client);
    boolean validatePassword(String password);
}
