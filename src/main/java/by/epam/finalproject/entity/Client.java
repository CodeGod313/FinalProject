package by.epam.finalproject.entity;

import java.util.List;

public class Client extends User{
    private String passportNumber;
    private String phoneNumber;
    private List<CreditType> deposits;
    private List<DepositType> depositTypes;
    private List<Account> accounts;
}