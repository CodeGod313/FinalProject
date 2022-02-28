package by.epam.finalproject.model.factory.impl;

import by.epam.finalproject.model.entity.Company;
import by.epam.finalproject.model.factory.CompanyFactory;

import java.math.BigDecimal;

public class CompanyFactoryImpl implements CompanyFactory {
    @Override
    public Company createCompanyFromStringValues(String companyName, String companyShortName, String sharePrice, String companyDescription, String imagePath) {
        BigDecimal sharePriceDecimal = new BigDecimal(sharePrice);
        Company company = new Company(companyName, companyShortName, companyDescription, sharePriceDecimal, imagePath);
        return company;
    }
}
