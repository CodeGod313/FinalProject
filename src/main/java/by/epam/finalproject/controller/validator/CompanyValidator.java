package by.epam.finalproject.controller.validator;

public interface CompanyValidator {
    boolean validateCompanyParameters(String companyName, String companyShortName, String sharePrice, String companyDescription);
    boolean isPossibleName(String companyName);
}
