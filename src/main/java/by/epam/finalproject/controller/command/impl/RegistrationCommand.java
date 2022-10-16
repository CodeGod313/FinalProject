package by.epam.finalproject.controller.command.impl;

import by.epam.finalproject.controller.Router;
import by.epam.finalproject.controller.command.Command;
import by.epam.finalproject.model.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        return null;
    }
}
