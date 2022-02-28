package by.epam.finalproject.model.entity;

import java.math.BigDecimal;

public class Crypto extends CleverEntity {

    private String name;
    private String shortName;
    private String description;
    private String cryptoHash;
    private String imagePath;
    private BigDecimal price;

    public Crypto() {
    }

    public Crypto(Long id, String name, String shortName, String description, String cryptoHash, BigDecimal price, String imagePath) {
        super(id);
        this.name = name;
        this.shortName = shortName;
        this.description = description;
        this.cryptoHash = cryptoHash;
        this.price = price;
        this.imagePath = imagePath;
    }

    public Crypto(String name, String shortName, String description, String cryptoHash, String imagePath, BigDecimal price) {
        this.name = name;
        this.shortName = shortName;
        this.description = description;
        this.cryptoHash = cryptoHash;
        this.imagePath = imagePath;
        this.price = price;
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

    public String getCryptoHash() {
        return cryptoHash;
    }

    public void setCryptoHash(String cryptoHash) {
        this.cryptoHash = cryptoHash;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
