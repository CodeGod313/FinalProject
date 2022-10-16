package by.epam.finalproject.model.entity;

import java.time.Instant;

public class CryptoChange extends CleverEntity{
    private Crypto crypto;
    private Instant changeTime;

    public CryptoChange(Long id, Crypto crypto, Instant changeTime) {
        super(id);
        this.crypto = crypto;
        this.changeTime = changeTime;
    }
}
