package by.epam.finalproject.controller.command.impl;

import by.epam.finalproject.controller.command.Command;
import by.epam.finalproject.controller.command.CommandFactory;
import by.epam.finalproject.controller.command.CommandType;

import java.util.Optional;

public class CommandFactoryImpl implements CommandFactory {
    @Override
    public Optional<Command> createCommand(CommandType commandType) {
        switch (commandType) {
            case REGISTRATION -> {
            }
            case LOG_IN -> {
                return Optional.of(new LogInCommand());
            }
            case CHANGE_LOCALE -> {
                return Optional.of(new ChangeLocaleCommand());
            }
            case COMPANY_CREATION -> {
                return Optional.of(new CompanyCreationCommand());
            }
            case DISPLAY_COMPANIES -> {
                return Optional.of(new DisplayCompaniesCommand());
            }
            case CRYPTO_CREATION -> {
                return Optional.of(new CryptoCreationCommand());
            }
            default -> {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }
}
