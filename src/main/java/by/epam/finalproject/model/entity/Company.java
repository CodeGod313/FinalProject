package by.epam.finalproject.model.entity;

import java.math.BigDecimal;

public class Company extends CleverEntity {
    private String name;
    private String shortName;
    private String description;
    private BigDecimal sharePrice;
    private String imagePath;

    public Company() {
    }

    public Company(String name, String shortName, String description, BigDecimal sharePrice, String imagePath) {
        this.name = name;
        this.shortName = shortName;
        this.description = description;
        this.sharePrice = sharePrice;
        this.imagePath = imagePath;
    }

    public Company(Long id, String name, String shortName, String description, BigDecimal sharePrice, String imagePath) {
        super(id);
        this.name = name;
        this.shortName = shortName;
        this.description = description;
        this.sharePrice = sharePrice;
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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
