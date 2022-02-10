package by.epam.finalproject.model.entity;

import java.math.BigDecimal;

public class CoinType {
    private Long id;
    private String name;
    private String shortName;
    private String description;
    private String coin_function;
    private BigDecimal price;

    public CoinType(Long id, String name, String shortName, String description, String coin_function, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.description = description;
        this.coin_function = coin_function;
        this.price = price;
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

    public String getCoin_function() {
        return coin_function;
    }

    public void setCoin_function(String coin_function) {
        this.coin_function = coin_function;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
