package by.epam.finalproject.model.dao.impl;

import by.epam.finalproject.model.dao.ShareDao;
import by.epam.finalproject.model.entity.Share;
import by.epam.finalproject.model.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ShareDaoImpl implements ShareDao {
    public static final String SHARES_NUMBER_COLUMN = "shares_number";
    public static final String GET_SHARE_BY_CLIENT_ID_AND_COMPANY_ID_QUERY = "SELECT share_id, shares_number FROM shares WHERE owner_id = ? AND company_id = ?";
    public static final String SHARE_ID_COLUMN = "share_id";
    static Logger logger = LogManager.getLogger(ShareDaoImpl.class);
    public static final String SHARE_CREATE_QUERY = "INSERT INTO shares(owner_id, company_id, shares_number) VALUES (?,?,?)";
    Connection connection;

    @Override
    public Optional<Share> getById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public void create(Share entity) throws DaoException {
        if (connection == null) {
            throw new DaoException("Connection is null");
        }
        try (PreparedStatement statement = connection.prepareStatement(SHARE_CREATE_QUERY)) {
            statement.setLong(1, entity.getOwnerId());
            statement.setLong(2, entity.getCompanyId());
            statement.setInt(3, entity.getNumberOfShares());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can not ceate share", e);
            throw new DaoException("Can not create share", e);
        }
    }

    @Override
    public void update(Share entity) throws DaoException {

    }

    @Override
    public void delete(Long id) throws DaoException {

    }

    @Override
    public Optional<Share> getByClientIdAndCompanyId(Long clientId, Long companyId) throws DaoException {
        Optional<Share> share = Optional.empty();
        try (PreparedStatement statement = connection.prepareStatement(GET_SHARE_BY_CLIENT_ID_AND_COMPANY_ID_QUERY)) {
            statement.setLong(1, clientId);
            statement.setLong(2, companyId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long shareId = resultSet.getLong(SHARE_ID_COLUMN);
                Integer numberOfShares = resultSet.getInt(SHARES_NUMBER_COLUMN);
                share = Optional.of(new Share(shareId, companyId, clientId, numberOfShares));
            }
        } catch (SQLException e) {
            logger.error("Can not get share", e);
            throw new DaoException("Can not get share", e);
        }
        return share;
    }

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
