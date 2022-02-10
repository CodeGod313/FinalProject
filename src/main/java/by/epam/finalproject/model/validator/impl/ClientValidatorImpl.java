package by.epam.finalproject.model.validator.impl;

import by.epam.finalproject.model.entity.Client;
import by.epam.finalproject.model.validator.ClientValidator;

public class ClientValidatorImpl implements ClientValidator {

    public static final String FIRST_NAME_AND_LAST_NAME_REGEX = "[A-ZА-Я][a-zа-я]{2,14}";
    public static final String EMAIL_REGEX = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-z]{2,3}";
    public static final String PASSWORD_REGEX = "[A-Za-z0-9]{8,16}";
    public static final String PASSPORT_SERIES_REGEX = "[A-Z]{2}";
    public static final String PASSPORT_NUMBER_REGEX = "\\d{7}";

    @Override
    public boolean validate(Client client) {
        return client.getFirstName() != null
                && client.getLastName() != null
                && client.getEmail() != null
                && client.getPassword() != null
                && client.getPassport_series() != null
                && client.getPassport_number() != null
                && client.getFirstName().matches(FIRST_NAME_AND_LAST_NAME_REGEX)
                && client.getLastName().matches(FIRST_NAME_AND_LAST_NAME_REGEX)
                && client.getEmail().matches(EMAIL_REGEX) && client.getPassword().matches(PASSWORD_REGEX)
                && client.getPassport_series().matches(PASSPORT_SERIES_REGEX)
                && client.getPassport_number().matches(PASSPORT_NUMBER_REGEX);
    }
}
