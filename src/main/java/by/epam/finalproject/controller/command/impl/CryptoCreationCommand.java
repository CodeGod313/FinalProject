package by.epam.finalproject.controller.command.impl;

import by.epam.finalproject.controller.Router;
import by.epam.finalproject.controller.RouterType;
import by.epam.finalproject.controller.command.Command;
import by.epam.finalproject.controller.validator.CryptoValidator;
import by.epam.finalproject.controller.validator.impl.CryptoValidatorImpl;
import by.epam.finalproject.model.exception.CommandException;
import by.epam.finalproject.model.exception.ServiceException;
import by.epam.finalproject.model.service.CryptoService;
import by.epam.finalproject.model.service.impl.CryptoServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static by.epam.finalproject.controller.Controller.IMAGES_FOLDER_ATTRIBUTE;
import static by.epam.finalproject.controller.command.impl.ChangeLocaleCommand.CURRENT_PAGE_ATTRIBUTE;

public class CryptoCreationCommand implements Command {
    public static final String DOT = ".";
    public static final String DISPLAY_CRYPTOS_COMMAND = "/controller?command=display_cryptos";
    public static final String WRONG_CRYPTO_NAME_ATTRIBUTE = "wrongCryptoName";
    public static final String WRONG_PARAMETERS_ATTRIBUTE = "wrongParameters";
    static Logger logger = LogManager.getLogger(CryptoCreationCommand.class);

    public static final String CRYPTO_HASH_PARAMETER = "cryptoHash";
    public static final String CRYPTO_DESCRIPTION_PARAMETER = "cryptoDescription";
    public static final String CRYPTO_PRICE_PARAMETER = "cryptoPrice";
    public static final String CRYPTO_SHORT_NAME_PARAMETER = "cryptoShortName";
    public static final String CRYPTO_NAME_PARAMETER = "cryptoName";
    public static final String CRYPTO_IMAGE_PART = "cryptoImage";

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String cryptoName = request.getParameter(CRYPTO_NAME_PARAMETER);
        String cryptoShortName = request.getParameter(CRYPTO_SHORT_NAME_PARAMETER);
        String cryptoPrice = request.getParameter(CRYPTO_PRICE_PARAMETER);
        String cryptoDescription = request.getParameter(CRYPTO_DESCRIPTION_PARAMETER);
        String cryptoHash = request.getParameter(CRYPTO_HASH_PARAMETER);
        HttpSession session = request.getSession();
        Part part = null;
        try {
            part = request.getPart(CRYPTO_IMAGE_PART);
        } catch (IOException | ServletException e) {
            logger.warn("Can not get file from request", e);
            e.printStackTrace();
        }
        String currentPage = session.getAttribute(CURRENT_PAGE_ATTRIBUTE).toString();
        CryptoValidator cryptoValidator = new CryptoValidatorImpl();
        Router router;
        String imagesFolder = request.getServletContext().getAttribute(IMAGES_FOLDER_ATTRIBUTE).toString();
        if (cryptoValidator.validateCryptoParameters(cryptoName, cryptoShortName, cryptoPrice, cryptoDescription, cryptoHash) && part != null) {
            if (cryptoValidator.isPossibleName(cryptoName)) {
                CryptoService cryptoService = new CryptoServiceImpl();
                String fileName = part.getSubmittedFileName();
                String extension = fileName.substring(fileName.lastIndexOf(DOT));
                String filePath = UUID.randomUUID() + extension;
                try {
                    part.write(imagesFolder + File.separator + filePath);
                    cryptoService.createCrypto(cryptoName, cryptoShortName, cryptoPrice, cryptoDescription, cryptoHash, filePath);
                } catch (IOException e) {
                    logger.error("Can not save file");
                } catch (ServiceException e) {
                    logger.error("Can not create crypto");
                }

                router = new Router(RouterType.REDIRECT, DISPLAY_CRYPTOS_COMMAND);
            } else {
                router = new Router(RouterType.FORWARD, currentPage);
                request.setAttribute(WRONG_CRYPTO_NAME_ATTRIBUTE, true);
            }
        } else {
            router = new Router(RouterType.FORWARD, currentPage);
            request.setAttribute(WRONG_PARAMETERS_ATTRIBUTE, true);
        }
        return router;
    }
}
