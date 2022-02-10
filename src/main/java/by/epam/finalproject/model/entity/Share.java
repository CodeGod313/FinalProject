package by.epam.finalproject.model.entity;

public class Share {
    private Long id;
    private Company company;
    private Integer numberOfShares;

    public Share(Long id, Company company, Integer numberOfShares) {
        this.id = id;
        this.company = company;
        this.numberOfShares = numberOfShares;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(Integer numberOfShares) {
        this.numberOfShares = numberOfShares;
    }
}
