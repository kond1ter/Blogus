package com.konditer.blogus.dto;

import java.time.LocalDate;

public class UserDto {
    public String name;
    public LocalDate birthDate;
    public LocalDate registrationDate;
    public double rating;

    public UserDto(String name, LocalDate birthDate, 
        LocalDate registrationDate, double rating) {
        
        this.name = name;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
        this.rating = rating;
    }
}
