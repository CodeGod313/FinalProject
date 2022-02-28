package by.epam.finalproject.controller;

import by.epam.finalproject.controller.command.Command;
import by.epam.finalproject.controller.command.CommandFactory;
import by.epam.finalproject.controller.command.CommandType;
import by.epam.finalproject.controller.command.impl.CommandFactoryImpl;
import by.epam.finalproject.model.exception.CommandException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@WebServlet(name = "controller", urlPatterns = "/controller")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 11
)
public class Controller extends HttpServlet {
    public static final String IMAGES_FOLDER = "images\\CleverExImages";
    public static final String IMAGES_FOLDER_ATTRIBUTE = "imagesFolder";
    public static final String EMPTY_STRING = "";
    static Logger logger = LogManager.getLogger(Controller.class);
    public static final String COMMAND_PARAMETER = "command";

    public void init() {
        String pathToImages = getServletContext().getRealPath(EMPTY_STRING) + IMAGES_FOLDER;
        Path path = Paths.get(pathToImages);
        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                logger.error("Can not create directory for application images", e);
            }
        }
        getServletContext().setAttribute(IMAGES_FOLDER_ATTRIBUTE, pathToImages);
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
        Optional<Command> commandOptional = commandFactory.createCommand(CommandType.valueOf(commandName.toUpperCase()));
        if (commandOptional.isPresent()) {
            Command command = commandOptional.get();
            Router router = null;
            try {
                router = command.execute(req, resp);
                RouterType routerType = router.getRouterType();
                switch (routerType) {
                    case FORWARD -> getServletContext().getRequestDispatcher(router.getPage()).forward(req, resp);
                    case REDIRECT -> resp.sendRedirect(req.getContextPath() + router.getPage());
                }
            } catch (CommandException e) {
                logger.error("Internal server error", e);
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }

        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
