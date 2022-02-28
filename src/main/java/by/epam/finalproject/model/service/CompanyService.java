package by.epam.finalproject.model.service;

import by.epam.finalproject.model.entity.Company;
import by.epam.finalproject.model.exception.ServiceException;

import java.util.List;

public interface CompanyService {
    void createCompany(String companyName, String companyShortName, String sharePrice, String companyDescription, String imagePath) throws ServiceException;
    List<Company> findAllCompanies() throws ServiceException;
}
