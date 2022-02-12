package by.epam.finalproject.model.service.impl;

import by.epam.finalproject.model.dao.Dao;
import by.epam.finalproject.model.dao.impl.AccountDaoImpl;
import by.epam.finalproject.model.dao.impl.CompanyDaoImpl;
import by.epam.finalproject.model.dao.impl.ShareDaoImpl;
import by.epam.finalproject.model.entity.Account;
import by.epam.finalproject.model.entity.Company;
import by.epam.finalproject.model.entity.Share;
import by.epam.finalproject.model.exception.WrongParameterException;
import by.epam.finalproject.model.service.SharesService;
import by.epam.finalproject.model.service.TransactionService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.Optional;

public class SharesServiceImpl implements SharesService {
    static Logger logger = LogManager.getLogger(SharesServiceImpl.class);

    @Override
    public boolean buyShares(Integer quantity, Long clientId, Long companyId) throws WrongParameterException {
        if (quantity == null || clientId == null || companyId == null || quantity <= 0 || clientId < 1 || companyId < 1) {
            throw new WrongParameterException("Parameters are wrong");
        }
        try (TransactionService transactionService = new TransactionServiceImpl()) {
            AccountDaoImpl accountDao = new AccountDaoImpl();
            Dao<Company> companyDao = new CompanyDaoImpl();
            Dao<Share> shareDao = new ShareDaoImpl();
            transactionService.begin(accountDao, companyDao, shareDao);
            Optional<Company> companyOptional = companyDao.getById(companyId);
            if (!companyOptional.isPresent()) {
                logger.error("Company with id = " + companyId + "does not exist");
                return false;
            }
            Company company = companyOptional.get();
            Optional<Account> accountOptional = accountDao.getAccountByClientId(clientId);
            if (!accountOptional.isPresent()) {
                logger.error("Client with id = " + clientId + "does not exist");
                return false;
            }
            Account account = accountOptional.get();
            BigDecimal transactionAmmount = company.getSharePrice().multiply(new BigDecimal(quantity));
            if (transactionAmmount.compareTo(account.getValue()) > 0) {
                logger.error("Insufficient funds");
                return false;
            }
            account.setValue(account.getValue().subtract(transactionAmmount));
            accountDao.update(account);
            Share share = new Share(companyId, clientId, quantity);
            shareDao.create(share);
            transactionService.commit();
        } catch (Exception e) {
            logger.error("An error occurred during the transaction", e);
            return false;
        }
        return true;
    }

    @Override
    public boolean sellShares(Integer quantity, Long clientId, Long companyId) throws WrongParameterException {
        if (quantity == null || clientId == null || companyId == null || quantity <= 0 || clientId < 1 || companyId < 1) {
            throw new WrongParameterException("Parameters are wrong");
        }
        try (TransactionService transactionService = new TransactionServiceImpl()) {
            AccountDaoImpl accountDao = new AccountDaoImpl();
            Dao<Company> companyDao = new CompanyDaoImpl();
            ShareDaoImpl shareDao = new ShareDaoImpl();
            transactionService.begin(accountDao, companyDao, shareDao);
            Optional<Company> companyOptional = companyDao.getById(companyId);
            if (!companyOptional.isPresent()) {
                logger.error("Company with id = " + companyId + "does not exist");
                return false;
            }
            Company company = companyOptional.get();
            Optional<Account> accountOptional = accountDao.getAccountByClientId(clientId);
            if (!accountOptional.isPresent()) {
                logger.error("Client with id = " + clientId + "does not exist");
                return false;
            }
            Account account = accountOptional.get();
            Optional<Share> shareOptional = shareDao.getByClientIdAndCompanyId(clientId, companyId);
            if (!shareOptional.isPresent()) {
                logger.error("Client has not shares of " + company.getName());
                return false;
            }
            Share share = shareOptional.get();
            if (share.getNumberOfShares() < quantity) {
                logger.error("Client has insufficient shares");
                return false;
            }
            BigDecimal transactionAmount = company.getSharePrice().multiply(new BigDecimal(quantity));
            account.setValue(account.getValue().add(transactionAmount));
            accountDao.update(account);
            share.setNumberOfShares(share.getNumberOfShares() - quantity);
            if (share.getNumberOfShares() == 0) {
                shareDao.delete(share.getId());
            } else {
                shareDao.update(share);
            }
            transactionService.commit();
        } catch (Exception e) {
            logger.error("An error occurred during the transaction", e);
            return false;
        }
        return true;
    }
}
