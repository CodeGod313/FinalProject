package by.epam.finalproject.controller.validator.impl;

import by.epam.finalproject.controller.locale.Locale;
import by.epam.finalproject.controller.validator.LocaleValidator;

public class LocaleValidatorImpl implements LocaleValidator {
    @Override
    public boolean validateLocaleParameter(String nextLocale) {
        if (nextLocale == null) {
            return false;
        }
        try {
            Locale locale = Locale.valueOf(nextLocale.toUpperCase());
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
