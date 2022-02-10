package by.epam.finalproject.model.entity;

import java.math.BigDecimal;

public class Account {
    private Long id;
    private BigDecimal value;

    public Account(Long id, BigDecimal value) {
        this.id = id;
        this.value = value;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}