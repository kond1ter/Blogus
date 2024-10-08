package com.konditer.blogus.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

public class UserDto {
    private int id;
    private String name;
    private LocalDate birthDate;
    private double rating;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public UserDto() {}

    public UserDto(
        int id,
        String name, 
        LocalDate birthDate, 
        double rating, 
        Timestamp createdAt, 
        Timestamp updatedAt
    ) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.rating = rating;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
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
