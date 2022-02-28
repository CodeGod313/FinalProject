package by.epam.finalproject.controller.validator.impl;

import by.epam.finalproject.controller.validator.CompanyValidator;
import by.epam.finalproject.model.dao.CompanyDao;
import by.epam.finalproject.model.dao.impl.CompanyDaoImpl;
import by.epam.finalproject.model.dbconnection.impl.ConnectionPoolImpl;
import by.epam.finalproject.model.entity.Company;
import by.epam.finalproject.model.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class CompanyValidatorImpl implements CompanyValidator {
    static Logger logger = LogManager.getLogger(CompanyValidatorImpl.class);
    public static final String REGEX_COMPANY_NAME = "[A-Z]+[a-z0-9]*";
    public static final String REGEX_COMPANY_SHORT_NAME = "[A-Z]{3,5}";
    public static final String REGEX_SHARE_PRICE = "\\d+";

    @Override
    public boolean validateCompanyParameters(String companyName, String companyShortName, String sharePrice, String companyDescription) {
        return companyName != null &&
                companyShortName != null &&
                companyDescription != null &&
                sharePrice != null &&
                companyName.matches(REGEX_COMPANY_NAME) &&
                companyShortName.matches(REGEX_COMPANY_SHORT_NAME) &&
                sharePrice.matches(REGEX_SHARE_PRICE);
    }

    @Override
    public boolean isPossibleName(String companyName) {
        CompanyDao companyDao = new CompanyDaoImpl();
        try (Connection connection = ConnectionPoolImpl.getInstance().getConnection()) {
            companyDao.setConnection(connection);
            Optional<Company> company = companyDao.getByName(companyName);
            return company.isEmpty();
        } catch (SQLException | DaoException e) {
            logger.error("Connection problems", e);
        }
        return false;
    }
}
