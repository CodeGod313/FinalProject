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
                return Optional.of(new RegistrationCommandImpl());
            }
            case LOG_IN -> {

            }
            case COMPANIES -> {
            }
            case CRYPTOS -> {

            }

            default ->{
                return Optional.empty();
            }
        }
        return Optional.empty();
    }
}
