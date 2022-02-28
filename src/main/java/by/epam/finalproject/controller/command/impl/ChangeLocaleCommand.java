package by.epam.finalproject.controller.command.impl;

import by.epam.finalproject.controller.Router;
import by.epam.finalproject.controller.RouterType;
import by.epam.finalproject.controller.command.Command;
import by.epam.finalproject.controller.validator.LocaleValidator;
import by.epam.finalproject.controller.validator.impl.LocaleValidatorImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeLocaleCommand implements Command {
    public static final String LOCALE_PARAMETER = "locale";
    public static final String RU_LOCALE = "ru_RU";
    public static final String CURRENT_PAGE_ATTRIBUTE = "currentPage";

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String nextLocale = request.getParameter(LOCALE_PARAMETER);
        LocaleValidator localeValidator = new LocaleValidatorImpl();
        if (localeValidator.validateLocaleParameter(nextLocale)) {
            session.setAttribute(LOCALE_PARAMETER, nextLocale);
        } else {
            session.setAttribute(LOCALE_PARAMETER, RU_LOCALE);
        }
        String currentPage = session.getAttribute(CURRENT_PAGE_ATTRIBUTE).toString();
        Router router = new Router(RouterType.FORWARD, currentPage);
        return router;
    }
}
