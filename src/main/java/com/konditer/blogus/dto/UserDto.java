package com.konditer.blogus.dto;

import java.time.LocalDate;

public class UserDto {
    private String name;
    private LocalDate birthDate;
    private double rating;

    public UserDto() {}

    public UserDto(String name, LocalDate birthDate, double rating) {
        
        this.name = name;
        this.birthDate = birthDate;
        this.rating = rating;
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
}
