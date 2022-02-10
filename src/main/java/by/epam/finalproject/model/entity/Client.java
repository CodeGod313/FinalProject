package by.epam.finalproject.model.entity;

import java.util.List;

public class Client extends User {
    public static final String CLIENT_ROLE = "client";
    private String passport_series;
    private String passport_number;
    private Account account;
    private List<Share> shares;
    private List<CoinAccount> coinAccounts;

    public Client(Long id, String firstName, String lastName, String email, String password, String role, String passport_series, String passport_number, Account account, List<Share> shares, List<CoinAccount> coinAccounts) {
        super(id, firstName, lastName, email, password, role);
        this.passport_series = passport_series;
        this.passport_number = passport_number;
        this.account = account;
        this.shares = shares;
        this.coinAccounts = coinAccounts;
    }

    public Client(String firstName, String lastName, String email, String password, String passport_series, String passport_number) {
        super(firstName, lastName, email, password, "client");
        this.passport_series = passport_series;
        this.passport_number = passport_number;
    }

    public String getPassport_series() {
        return passport_series;
    }

    public void setPassport_series(String passport_series) {
        this.passport_series = passport_series;
    }

    public String getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(String passport_number) {
        this.passport_number = passport_number;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Share> getShares() {
        return shares;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }

    public List<CoinAccount> getCoinAccounts() {
        return coinAccounts;
    }

    public void setCoinAccounts(List<CoinAccount> coinAccounts) {
        this.coinAccounts = coinAccounts;
    }
}
