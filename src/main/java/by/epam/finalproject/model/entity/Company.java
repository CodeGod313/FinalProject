package by.epam.finalproject.model.entity;

import java.math.BigDecimal;

public class Company {
    private Long id;
    private String name;
    private String shortName;
    private String description;
    private BigDecimal sharePrice;
    private Integer shareQuantity;

    public Company(Long id, String name, String shortName, String description, BigDecimal sharePrice, Integer shareQuantity) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.description = description;
        this.sharePrice = sharePrice;
        this.shareQuantity = shareQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getShareQuantity() {
        return shareQuantity;
    }

    public void setShareQuantity(Integer shareQuantity) {
        this.shareQuantity = shareQuantity;
    }
}
