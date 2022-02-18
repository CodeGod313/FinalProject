package by.epam.finalproject.controller.filter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "CurrentPageFilter", urlPatterns = {"*.jsp"})
public class CurrentPageFilter implements Filter {
    public static final String CURRENT_PAGE_ATTRIBUTE = "currentPage";
    static Logger logger = LogManager.getLogger(CurrentPageFilter.class);
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String currentPage = (servletRequest).getRequestURI();
        HttpSession session = servletRequest.getSession();
        session.setAttribute(CURRENT_PAGE_ATTRIBUTE, currentPage);
        logger.info("Current page is " + currentPage);
        chain.doFilter(request, response);
    }
}
