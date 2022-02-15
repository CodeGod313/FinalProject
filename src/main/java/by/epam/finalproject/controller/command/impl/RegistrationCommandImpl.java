package by.epam.finalproject.controller.command.impl;

import by.epam.finalproject.controller.command.Command;
import by.epam.finalproject.controller.util.PagesContainer;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommandImpl implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        return PagesContainer.REGISTRATION_PAGE;
    }
}
