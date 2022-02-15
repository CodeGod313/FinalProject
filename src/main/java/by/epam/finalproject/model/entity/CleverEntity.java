package by.epam.finalproject.model.entity;

import java.io.Serializable;

abstract class CleverEntity implements Cloneable, Serializable {
    private Long id;

    public CleverEntity() {
    }

    public CleverEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
