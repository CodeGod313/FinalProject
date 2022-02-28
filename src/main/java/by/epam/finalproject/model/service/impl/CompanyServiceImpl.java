package by.epam.finalproject.model.service.impl;


import by.epam.finalproject.model.dao.CompanyDao;
import by.epam.finalproject.model.dao.impl.CompanyDaoImpl;
import by.epam.finalproject.model.dbconnection.impl.ConnectionPoolImpl;
import by.epam.finalproject.model.entity.Company;
import by.epam.finalproject.model.exception.DaoException;
import by.epam.finalproject.model.exception.ServiceException;
import by.epam.finalproject.model.factory.CompanyFactory;
import by.epam.finalproject.model.factory.impl.CompanyFactoryImpl;
import by.epam.finalproject.model.service.CompanyService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CompanyServiceImpl implements CompanyService {
    static Logger logger = LogManager.getLogger(CompanyServiceImpl.class);

    @Override
    public void createCompany(String companyName, String companyShortName, String sharePrice, String companyDescription, String imagePath) throws ServiceException {
        CompanyFactory companyFactory = new CompanyFactoryImpl();
        Company company = companyFactory.createCompanyFromStringValues(companyName, companyShortName, sharePrice, companyDescription, imagePath);
        CompanyDao companyDao = new CompanyDaoImpl();
        try (Connection connection = ConnectionPoolImpl.getInstance().getConnection()) {
            companyDao.setConnection(connection);
            companyDao.create(company);
        } catch (SQLException | DaoException e) {
            logger.error("Can not create new company", e);
            throw new ServiceException("Can not create new company", e);
        }
    }

    @Override
    public List<Company> findAllCompanies() throws ServiceException {
        CompanyDao companyDao = new CompanyDaoImpl();
        List<Company> companies;
        try (Connection connection = ConnectionPoolImpl.getInstance().getConnection()) {
            companyDao.setConnection(connection);
            companies = companyDao.getAll();
        } catch (SQLException | DaoException e) {
            logger.error("Can not get companies from database", e);
            throw new ServiceException("Can not get companies from database", e);
        }
        return companies;
    }
}
