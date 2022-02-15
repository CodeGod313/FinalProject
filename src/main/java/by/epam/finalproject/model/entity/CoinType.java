package by.epam.finalproject.model.entity;

import java.math.BigDecimal;

public class CoinType extends CleverEntity {

    private String name;
    private String shortName;
    private String description;
    private String coinFunction;
    private BigDecimal price;

    public CoinType() {
    }

    public CoinType(Long id, String name, String shortName, String description, String coinFunction, BigDecimal price) {
        super(id);
        this.name = name;
        this.shortName = shortName;
        this.description = description;
        this.coinFunction = coinFunction;
        this.price = price;
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

    public String getCoinFunction() {
        return coinFunction;
    }

    public void setCoinFunction(String coinFunction) {
        this.coinFunction = coinFunction;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
