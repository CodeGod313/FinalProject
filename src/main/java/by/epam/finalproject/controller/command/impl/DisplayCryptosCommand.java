package by.epam.finalproject.controller.command.impl;

import by.epam.finalproject.controller.PaginationContainer;
import by.epam.finalproject.controller.Router;
import by.epam.finalproject.controller.RouterType;
import by.epam.finalproject.controller.command.Command;
import by.epam.finalproject.model.entity.Crypto;
import by.epam.finalproject.model.exception.CommandException;
import by.epam.finalproject.model.exception.ServiceException;
import by.epam.finalproject.model.service.CryptoService;
import by.epam.finalproject.model.service.impl.CryptoServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static by.epam.finalproject.controller.PageConstant.CRYPTOS_PAGE;

public class DisplayCryptosCommand implements Command {

    public static final String PAGES_ATTRIBUTE = "pages";
    public static final String CURRENT_PAGE_ATTRIBUTE = "currentPage";
    static Logger logger = LogManager.getLogger(DisplayCryptosCommand.class);
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
        CryptoService cryptoService = new CryptoServiceImpl();
        List<Crypto> cryptos;
        try {
            cryptos = cryptoService.findAllCryptos();
        } catch (ServiceException e) {
            logger.error("Can not display companies", e);
            throw new CommandException("Can not display companies", e);
        }
        PaginationContainer<Crypto> paginationContainer = new PaginationContainer<>(cryptos, ITEMS_PER_PAGE);
        Integer maxPage = paginationContainer.countMaxPage();
        List<Integer> pages = new ArrayList<>();
        for (int i = 0; i < maxPage; i++) {
            pages.add(i + 1);
        }
        request.setAttribute(PAGES_ATTRIBUTE, pages);
        List<Crypto> pageItems = paginationContainer.generatePageItemList(page);
        request.setAttribute(PAGE_ITEMS_ATTRIBUTE, pageItems);
        request.setAttribute(PAGE_PARAMETER, page);
        HttpSession session = request.getSession();
        session.setAttribute(CURRENT_PAGE_ATTRIBUTE, CRYPTOS_PAGE);
        Router router = new Router(RouterType.FORWARD, CRYPTOS_PAGE);
        return router;
    }
}
