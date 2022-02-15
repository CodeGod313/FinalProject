package by.epam.finalproject.controller.command;

import java.util.Optional;

public interface CommandFactory {
    Optional<Command> createCommand(CommandType commandType);
}
