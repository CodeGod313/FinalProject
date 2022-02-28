package by.epam.finalproject.model.dao.impl;

import by.epam.finalproject.model.dao.CompanyDao;
import by.epam.finalproject.model.entity.Company;
import by.epam.finalproject.model.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CompanyDaoImpl implements CompanyDao {
    public static final String COMPANY_NAME_COLUMN = "company_name";
    public static final String COMPANY_SHORT_NAME_COLUMN = "company_short_name";
    public static final String COMPANY_DESCRIPTION_COLUMN = "company_description";
    public static final String SHARE_PRICE_COLUMN = "share_price";
    public static final String COMPANY_BY_ID_QUERY = "SELECT company_name, company_short_name, company_description, share_price, image_path FROM companies WHERE company_id = ?";
    public static final String COMPANY_BY_NAME_QUERY = "SELECT company_name, company_short_name, company_description, share_price, image_path FROM companies WHERE company_name = ?";
    public static final String COMPANY_ID_COLUMN = "company_id";
    public static final String IMAGE_PATH_COLUMN = "image_path";
    public static final String CREATE_COMPANY_QUERY = "INSERT INTO companies(company_name, company_short_name, company_description, share_price, image_path) VALUES(?,?,?,?,?)";
    public static final String GET_ALL_COMPANIES_QUERY = "SELECT company_id, company_name, company_short_name, company_description, share_price, image_path FROM companies";
    Connection connection;
    static Logger logger = LogManager.getLogger(CompanyDaoImpl.class);

    @Override
    public Optional<Company> getById(Long id) throws DaoException {
        if (connection == null) {
            throw new DaoException("Connection is null");
        }
        Optional<Company> company = Optional.empty();
        try (PreparedStatement statement = connection.prepareStatement(COMPANY_BY_ID_QUERY)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String companyName = resultSet.getString(COMPANY_NAME_COLUMN);
                String companyShortName = resultSet.getString(COMPANY_SHORT_NAME_COLUMN);
                String companyDescription = resultSet.getString(COMPANY_DESCRIPTION_COLUMN);
                BigDecimal sharePrice = resultSet.getBigDecimal(SHARE_PRICE_COLUMN);
                String imagePath = resultSet.getString(IMAGE_PATH_COLUMN);
                company = Optional.of(new Company(id, companyName, companyShortName, companyDescription, sharePrice, imagePath));
            }
        } catch (SQLException e) {
            logger.error("Can not get company", e);
            throw new DaoException("Can not get company", e);
        }
        return company;
    }

    @Override
    public void create(Company entity) throws DaoException {
        if (connection == null) {
            throw new DaoException("Connection is null");
        }
        try (PreparedStatement statement = connection.prepareStatement(CREATE_COMPANY_QUERY)) {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getShortName());
            statement.setString(3, entity.getDescription());
            statement.setBigDecimal(4, entity.getSharePrice());
            statement.setString(5, entity.getImagePath());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can not create company", e);
            throw new DaoException("Can not create company", e);
        }
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

    @Override
    public Optional<Company> getByName(String companyName) throws DaoException {
        if (connection == null) {
            throw new DaoException("Connection is null");
        }
        Optional<Company> company = Optional.empty();
        try (PreparedStatement statement = connection.prepareStatement(COMPANY_BY_NAME_QUERY)) {
            statement.setString(1, companyName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long id = resultSet.getLong(COMPANY_ID_COLUMN);
                String companyShortName = resultSet.getString(COMPANY_SHORT_NAME_COLUMN);
                String companyDescription = resultSet.getString(COMPANY_DESCRIPTION_COLUMN);
                BigDecimal sharePrice = resultSet.getBigDecimal(SHARE_PRICE_COLUMN);
                String imagePath = resultSet.getString(IMAGE_PATH_COLUMN);
                company = Optional.of(new Company(id, companyName, companyShortName, companyDescription, sharePrice, imagePath));
            }
        } catch (SQLException e) {
            logger.error("Can not get company by name", e);
            throw new DaoException("Can not get company by name", e);
        }
        return company;
    }

    @Override
    public List<Company> getAll() throws DaoException {
        if (connection == null) {
            throw new DaoException("Connection is null");
        }
        List<Company> companies = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_COMPANIES_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong(COMPANY_ID_COLUMN);
                String companyName = resultSet.getString(COMPANY_NAME_COLUMN);
                String companyShortName = resultSet.getString(COMPANY_SHORT_NAME_COLUMN);
                String companyDescription = resultSet.getString(COMPANY_DESCRIPTION_COLUMN);
                BigDecimal sharePrice = resultSet.getBigDecimal(SHARE_PRICE_COLUMN);
                String imagePath = resultSet.getString(IMAGE_PATH_COLUMN);
                companies.add(new Company(id, companyName, companyShortName, companyDescription, sharePrice, imagePath));
            }
        } catch (SQLException e) {
            logger.error("Can get all companies", e);
            throw new DaoException("Can get all companies", e);
        }
        return companies;
    }
}
