package by.epam.finalproject.model.factory;

import by.epam.finalproject.model.entity.Company;

public interface CompanyFactory {
    Company createCompanyFromStringValues(String companyName, String companyShortName, String sharePrice, String companyDescription, String imagePath);
}
