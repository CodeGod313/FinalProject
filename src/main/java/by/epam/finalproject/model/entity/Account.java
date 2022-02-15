package by.epam.finalproject.model.entity;

import java.math.BigDecimal;

public class Account extends CleverEntity{
    private BigDecimal value;

    public Account() {
    }

    public Account(Long id, BigDecimal value) {
        super(id);
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
