package by.epam.finalproject.controller.command.impl;

import by.epam.finalproject.controller.Router;
import by.epam.finalproject.controller.RouterType;
import by.epam.finalproject.controller.command.Command;
import by.epam.finalproject.controller.validator.CompanyValidator;
import by.epam.finalproject.controller.validator.impl.CompanyValidatorImpl;
import by.epam.finalproject.model.exception.CommandException;
import by.epam.finalproject.model.exception.ServiceException;
import by.epam.finalproject.model.service.CompanyService;
import by.epam.finalproject.model.service.impl.CompanyServiceImpl;
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
import static by.epam.finalproject.controller.PageConstant.DISPLAY_COMPANIES_COMMAND;

public class CompanyCreationCommand implements Command {
    public static final String FILE_PART = "companyImage";
    public static final char DOT = '.';

    static Logger logger = LogManager.getLogger(CompanyCreationCommand.class);

    public static final String COMPANY_NAME_PARAMETER = "companyName";
    public static final String COMPANY_SHORT_NAME_PARAMETER = "companyShortName";
    public static final String SHARE_PRICE_PARAMETER = "sharePrice";
    public static final String COMPANY_DESCRIPTION_PARAMETER = "companyDescription";
    public static final String CURRENT_PAGE_ATTRIBUTE = "currentPage";
    public static final String WRONG_COMPANY_NAME_ATTRIBUTE = "wrongCompanyName";
    public static final String WRONG_PARAMETERS_ATTRIBUTE = "wrongParameters";


    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String companyName = request.getParameter(COMPANY_NAME_PARAMETER);
        String companyShortName = request.getParameter(COMPANY_SHORT_NAME_PARAMETER);
        String sharePrice = request.getParameter(SHARE_PRICE_PARAMETER);
        String companyDescription = request.getParameter(COMPANY_DESCRIPTION_PARAMETER);
        HttpSession session = request.getSession();
        Part part = null;
        try {
            part = request.getPart(FILE_PART);
        } catch (IOException | ServletException e) {
            logger.warn("Can not get file from request", e);
            e.printStackTrace();
        }
        String currentPage = session.getAttribute(CURRENT_PAGE_ATTRIBUTE).toString();
        CompanyValidator companyValidator = new CompanyValidatorImpl();
        Router router;
        String imagesFolder = request.getServletContext().getAttribute(IMAGES_FOLDER_ATTRIBUTE).toString();
        if (companyValidator.validateCompanyParameters(companyName, companyShortName, sharePrice, companyDescription) && part != null) {
            if (companyValidator.isPossibleName(companyName)) {
                CompanyService companyService = new CompanyServiceImpl();
                String fileName = part.getSubmittedFileName();
                String extension = fileName.substring(fileName.lastIndexOf(DOT));
                String filePath = UUID.randomUUID() + extension;
                try {
                    part.write(imagesFolder + File.separator + filePath);
                    companyService.createCompany(companyName, companyShortName, sharePrice, companyDescription, filePath);
                } catch (IOException e) {
                    logger.error("Can not save file");
                } catch (ServiceException e) {
                    logger.error("Can not create company");
                }
                router = new Router(RouterType.REDIRECT, DISPLAY_COMPANIES_COMMAND);
            } else {
                router = new Router(RouterType.FORWARD, currentPage);
                request.setAttribute(WRONG_COMPANY_NAME_ATTRIBUTE, true);
            }
        } else {
            router = new Router(RouterType.FORWARD, currentPage);
            request.setAttribute(WRONG_PARAMETERS_ATTRIBUTE, true);
        }
        return router;
    }
}
