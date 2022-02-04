package by.epam.finalproject.entity;

import java.math.BigDecimal;
import java.util.List;

public class CreditType {
    private String name;
    private String description;
    private Integer minNumberOfMonth;
    private Integer maxNumberOfMonth;
    private BigDecimal interestRate;
    private List<Currency> currencies;
}