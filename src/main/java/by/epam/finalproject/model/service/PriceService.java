package by.epam.finalproject.model.service;

import java.math.BigDecimal;

public interface PriceService {
    BigDecimal generatePriceRandomly(BigDecimal currentPrice);
}
