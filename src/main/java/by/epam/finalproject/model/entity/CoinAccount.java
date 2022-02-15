package by.epam.finalproject.model.entity;

import java.math.BigDecimal;

public class CoinAccount extends CleverEntity {
    private CoinType coinType;
    private BigDecimal quantityOfCoins;

    public CoinAccount() {
    }

    public CoinAccount(Long id, CoinType coinType, BigDecimal quantityOfCoins) {
        super(id);
        this.coinType = coinType;
        this.quantityOfCoins = quantityOfCoins;
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
