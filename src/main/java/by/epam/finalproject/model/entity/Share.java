package by.epam.finalproject.model.entity;

public class Share extends CleverEntity {

    private Long companyId;
    private Long ownerId;
    private Integer numberOfShares;

    public Share() {
    }

    public Share(Long id, Long companyId, Long ownerId, Integer numberOfShares) {
        super(id);
        this.companyId = companyId;
        this.ownerId = ownerId;
        this.numberOfShares = numberOfShares;
    }

    public Share(Long companyId, Long ownerId, Integer numberOfShares) {
        this.companyId = companyId;
        this.ownerId = ownerId;
        this.numberOfShares = numberOfShares;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Integer getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(Integer numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
