package com.konditer.blogus.entities;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PreUpdate;

@MappedSuperclass
public class BaseEntityUpdatable extends BaseEntity {

    @Override
    @PreUpdate
    protected void preUpdate() {}
    
    private Timestamp updatedAt;

    public BaseEntityUpdatable() {
        super();
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

    @Column(name = "updated_at")
    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
