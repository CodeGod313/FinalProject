package by.epam.finalproject.controller.command.impl;

import by.epam.finalproject.controller.PaginationContainer;
import by.epam.finalproject.controller.Router;
import by.epam.finalproject.controller.RouterType;
import by.epam.finalproject.controller.command.Command;
import by.epam.finalproject.model.entity.Company;
import by.epam.finalproject.model.exception.CommandException;
import by.epam.finalproject.model.exception.ServiceException;
import by.epam.finalproject.model.service.CompanyService;
import by.epam.finalproject.model.service.impl.CompanyServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static by.epam.finalproject.controller.PageConstant.COMPANIES_PAGE;

public class DisplayCompaniesCommand implements Command {
    public static final String PAGES_ATTRIBUTE = "pages";
    static Logger logger = LogManager.getLogger(DisplayCompaniesCommand.class);
    public static final String PAGE_PARAMETER = "page";
    public static final int FIRST_PAGE = 1;
    public static final int ITEMS_PER_PAGE = 8;
    public static final String PAGE_ITEMS_ATTRIBUTE = "pageItems";

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String pageString = request.getParameter(PAGE_PARAMETER);
        Integer page;
        if (pageString == null) {
            page = FIRST_PAGE;
        } else {
            page = Integer.parseInt(pageString);
        }
        CompanyService companyService = new CompanyServiceImpl();
        List<Company> companies;
        try {
            companies = companyService.findAllCompanies();
        } catch (ServiceException e) {
            logger.error("Can not display companies", e);
            throw new CommandException("Can not display companies", e);
        }
        PaginationContainer<Company> paginationContainer = new PaginationContainer<>(companies, ITEMS_PER_PAGE);
        Integer maxPage = paginationContainer.countMaxPage();
        List<Integer> pages = new ArrayList<>();
        for (int i = 0; i < maxPage; i++) {
            pages.add(i + 1);
        }
        request.setAttribute(PAGES_ATTRIBUTE, pages);
        List<Company> pageItems = paginationContainer.generatePageItemList(page);
        request.setAttribute(PAGE_ITEMS_ATTRIBUTE, pageItems);
        request.setAttribute(PAGE_PARAMETER, page);
        Router router = new Router(RouterType.FORWARD, COMPANIES_PAGE);
        return router;
    }
}
