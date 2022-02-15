package by.epam.finalproject.model.dao.impl;

import by.epam.finalproject.model.dao.Dao;
import by.epam.finalproject.model.entity.Company;
import by.epam.finalproject.model.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CompanyDaoImpl implements Dao<Company> {
    public static final String COMPANY_NAME_COLUMN = "company_name";
    public static final String COMPANY_SHORT_NAME_COLUMN = "company_short_name";
    public static final String COMPANY_DESCRIPTION_COLUMN = "company_description";
    public static final String SHARE_PRICE_COLUMN = "share_price";
    Connection connection;
    static Logger logger = LogManager.getLogger(CompanyDaoImpl.class);

    @Override
    public Optional<Company> getById(Long id) throws DaoException {
        if (connection == null) {
            throw new DaoException("Connection is null");
        }
        Optional<Company> company = Optional.empty();
        try (PreparedStatement statement = connection.prepareStatement("SELECT company_name, company_short_name, company_description, share_price FROM companies WHERE company_id = ?")) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String companyName = resultSet.getString(COMPANY_NAME_COLUMN);
                String companyShortName = resultSet.getString(COMPANY_SHORT_NAME_COLUMN);
                String companyDescription = resultSet.getString(COMPANY_DESCRIPTION_COLUMN);
                BigDecimal sharePrice = resultSet.getBigDecimal(SHARE_PRICE_COLUMN);
                company = Optional.of(new Company(id, companyName, companyShortName, companyDescription, sharePrice));
            }
        } catch (SQLException e) {
            logger.error("Can not get company", e);
            throw new DaoException("Can not get company", e);
        }
        return company;
    }

    @Override
    public void create(Company entity) throws DaoException {

    }

    @Override
    public void update(Company entity) throws DaoException {

    }

    @Override
    public void delete(Long id) throws DaoException {

    }

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
