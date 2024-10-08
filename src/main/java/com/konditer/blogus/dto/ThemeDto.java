package com.konditer.blogus.dto;

import java.sql.Timestamp;

public class ThemeDto {
    private int id;
    private String name;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public ThemeDto() {}

    public ThemeDto(
        String name
    ) {
        this.name = name;
    }

    public ThemeDto(
        int id,
        String name, 
        Timestamp createdAt, 
        Timestamp updatedAt
    ) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
