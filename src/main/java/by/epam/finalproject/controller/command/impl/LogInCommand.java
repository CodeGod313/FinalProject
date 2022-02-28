package by.epam.finalproject.controller.command.impl;

import by.epam.finalproject.controller.Router;
import by.epam.finalproject.controller.RouterType;
import by.epam.finalproject.controller.command.Command;
import by.epam.finalproject.model.entity.User;
import by.epam.finalproject.model.exception.CommandException;
import by.epam.finalproject.model.exception.ServiceException;
import by.epam.finalproject.model.service.UserService;
import by.epam.finalproject.model.service.impl.UserServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

import static by.epam.finalproject.controller.PageConstant.MAIN_PAGE;

public class LogInCommand implements Command {
    public static final String USER_ID_ATTRIBUTE = "userId";
    public static final String ROLE_ATTRIBUTE = "role";
    public static final String ALERT_ATTRIBUTE = "alert";
    public static final String CURRENT_PAGE_ATTRIBUTE = "currentPage";
    static Logger logger = LogManager.getLogger(LogInCommand.class);
    public static final String EMAIL_PARAMETER = "email";
    public static final String PASSWORD_PARAMETER = "password";

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        HttpSession session = request.getSession();
        String email = request.getParameter(EMAIL_PARAMETER);
        String password = request.getParameter(PASSWORD_PARAMETER);
        String currentPage = session.getAttribute(CURRENT_PAGE_ATTRIBUTE).toString();
        Router router;
        UserService userService = new UserServiceImpl();
        try {
            Optional<User> optionalUser = userService.logIn(email, password);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                session.setAttribute(USER_ID_ATTRIBUTE, user.getId());
                session.setAttribute(ROLE_ATTRIBUTE, user.getRole());
                router = new Router(RouterType.REDIRECT, MAIN_PAGE);
            } else {
                request.setAttribute(ALERT_ATTRIBUTE, true);
                router = new Router(RouterType.FORWARD, currentPage);
            }
        } catch (ServiceException e) {
            logger.error("Can not log in", e);
            throw new CommandException("Can not log in", e);
        }
        return router;
    }
}
