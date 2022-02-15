package by.epam.finalproject.controller;

import by.epam.finalproject.controller.command.Command;
import by.epam.finalproject.controller.command.CommandFactory;
import by.epam.finalproject.controller.command.CommandType;
import by.epam.finalproject.controller.command.impl.CommandFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "controller", urlPatterns = "/controller")
public class Controller extends HttpServlet {
    public static final String COMMAND_PARAMETER = "command";

    public void init() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    public void destroy() {
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter(COMMAND_PARAMETER);
        CommandFactory commandFactory = new CommandFactoryImpl();
        Optional<Command> commandOptional = commandFactory.createCommand(CommandType.valueOf(commandName));
        if (commandOptional.isPresent()) {
            Command command = commandOptional.get();
            getServletContext().getRequestDispatcher(command.execute(req)).forward(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }


}
