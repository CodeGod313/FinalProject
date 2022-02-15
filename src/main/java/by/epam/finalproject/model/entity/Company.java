package by.epam.finalproject.model.entity;

import java.math.BigDecimal;

public class Company extends CleverEntity {
    private String name;
    private String shortName;
    private String description;
    private BigDecimal sharePrice;

    public Company() {
    }

    public Company(Long id, String name, String shortName, String description, BigDecimal sharePrice) {
        super(id);
        this.name = name;
        this.shortName = shortName;
        this.description = description;
        this.sharePrice = sharePrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(BigDecimal sharePrice) {
        this.sharePrice = sharePrice;
    }
}
