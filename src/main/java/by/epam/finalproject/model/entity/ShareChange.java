package by.epam.finalproject.model.entity;

import java.time.Instant;

public class ShareChange extends CleverEntity{
    private Company company;
    private Instant changTime;

    public ShareChange(Long id, Company company, Instant changTime) {
        super(id);
        this.company = company;
        this.changTime = changTime;
    }
}
