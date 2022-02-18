package by.epam.finalproject.controller.command;


import by.epam.finalproject.controller.Router;
import by.epam.finalproject.model.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    Router execute(HttpServletRequest request, HttpServletResponse response) throws CommandException;
}
