package com.konditer.blogus.entities;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

    private int id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private boolean deleted;

    public BaseEntity() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
        this.deleted = false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return this.id;
    }

    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    @Column(name = "updated_at")
    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    @Column(name = "is_deleted")
    public boolean isDeleted() {
        return deleted;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
