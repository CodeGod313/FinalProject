package by.epam.finalproject.controller.command.impl;

import by.epam.finalproject.controller.Router;
import by.epam.finalproject.controller.RouterType;
import by.epam.finalproject.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeLocaleCommand implements Command {

    public static final String LOCALE_PARAMETER = "locale";
    public static final String RU_LOCALE = "ru_RU";
    public static final String EN_LOCALE = "en_US";
    public static final String CURRENT_PAGE_ATTRIBUTE = "currentPage";

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String nextLocale = request.getParameter(LOCALE_PARAMETER).toString();
        if (nextLocale.equals(RU_LOCALE)) {
            session.setAttribute(LOCALE_PARAMETER, RU_LOCALE);
        } else {
            session.setAttribute(LOCALE_PARAMETER, EN_LOCALE);
        }
        String currentPage = session.getAttribute(CURRENT_PAGE_ATTRIBUTE).toString();
        Router router = new Router(RouterType.FORWARD, currentPage);
        return router;
    }
}
