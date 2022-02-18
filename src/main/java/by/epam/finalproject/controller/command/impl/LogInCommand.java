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

public class LogInCommand implements Command {
    public static final String USER_ID_ATTRIBUTE = "userId";
    public static final String ROLE_ATTRIBUTE = "role";
    public static final String MAIN_PAGE = "/jsp/main.jsp";
    static Logger logger = LogManager.getLogger(LogInCommand.class);

    public static final String EMAIL_PARAMETER = "email";
    public static final String PASSWORD_PARAMETER = "password";

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        HttpSession session = request.getSession();
        String email = request.getParameter(EMAIL_PARAMETER);
        String password = request.getParameter(PASSWORD_PARAMETER);
        UserService userService = new UserServiceImpl();
        try {
            Optional<User> optionalUser = userService.logIn(email, password);
            if(optionalUser.isPresent()){
                User user = optionalUser.get();
                session.setAttribute(USER_ID_ATTRIBUTE, user.getId());
                session.setAttribute(ROLE_ATTRIBUTE, user.getRole());
            }
        } catch (ServiceException e) {
            logger.error("Can not log in", e);
            throw new CommandException("Can not log in", e);
        }
        Router router = new Router(RouterType.REDIRECT, MAIN_PAGE);
        return router;
    }
}
