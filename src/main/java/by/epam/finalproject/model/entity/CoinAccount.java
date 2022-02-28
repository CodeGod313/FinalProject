package by.epam.finalproject.model.entity;

import java.math.BigDecimal;

public class CoinAccount extends CleverEntity {
    private Crypto crypto;
    private BigDecimal quantityOfCoins;

    public CoinAccount() {
    }

    public CoinAccount(Long id, Crypto crypto, BigDecimal quantityOfCoins) {
        super(id);
        this.crypto = crypto;
        this.quantityOfCoins = quantityOfCoins;
    }

    public Crypto getCoinType() {
        return crypto;
    }

    public void setCoinType(Crypto crypto) {
        this.crypto = crypto;
    }

    public BigDecimal getQuantityOfCoins() {
        return quantityOfCoins;
    }

    public void setQuantityOfCoins(BigDecimal quantityOfCoins) {
        this.quantityOfCoins = quantityOfCoins;
    }
}
