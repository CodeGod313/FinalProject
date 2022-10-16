package by.epam.finalproject.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "DefaultSettingsFilter", urlPatterns = {"/*"})
public class DefaultSettingsFilter implements Filter {

    public static final String RU_LOCALE = "ru_RU";
    public static final String LOCALE_ATTRIBUTE = "locale";
    public static final String ROLE_ATTRIBUTE = "role";
    public static final String GUEST_ROLE = "guest";

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpSession session = servletRequest.getSession();
        Object locale = session.getAttribute(LOCALE_ATTRIBUTE);
        if (locale == null) {
            session.setAttribute(LOCALE_ATTRIBUTE, RU_LOCALE);
        }
        Object role = session.getAttribute(ROLE_ATTRIBUTE);
        if (role == null) {
            session.setAttribute(ROLE_ATTRIBUTE, GUEST_ROLE);
        }
        chain.doFilter(request, response);
    }
}
