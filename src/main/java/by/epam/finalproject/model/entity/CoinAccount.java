package by.epam.finalproject.model.entity;

import java.math.BigDecimal;

public class CoinAccount {
    private Long id;
    private CoinType coinType;
    private BigDecimal quantityOfCoins;

    public CoinAccount(Long id, CoinType coinType, BigDecimal quantityOfCoins) {
        this.id = id;
        this.coinType = coinType;
        this.quantityOfCoins = quantityOfCoins;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CoinType getCoinType() {
        return coinType;
    }

    public void setCoinType(CoinType coinType) {
        this.coinType = coinType;
    }

    public BigDecimal getQuantityOfCoins() {
        return quantityOfCoins;
    }

    public void setQuantityOfCoins(BigDecimal quantityOfCoins) {
        this.quantityOfCoins = quantityOfCoins;
    }
}
