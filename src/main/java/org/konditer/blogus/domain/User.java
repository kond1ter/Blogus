package org.konditer.blogus.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity @Table(name = "user", schema = "public")
public class User extends BaseEntity {
    private String name;
    private LocalDate birthDate;
    private LocalDate registrationDate;
    private double rating;
    private static final double DEFAULT_RATING = 1.0;

    public User() {}

    public User(String name, LocalDate birthDate) {
        this.setName(name);
        this.setBirthDate(birthDate);
        this.setRegistrationDate(LocalDate.now());
        this.setRating(DEFAULT_RATING);
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    @Column(name = "birth_date")
    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    @Column(name = "registration_date")
    public LocalDate getRegistrationDate() {
        return this.registrationDate;
    }

    @Column(name = "rating")
    public double getRating() {
        return this.rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public static String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = date.format(formatter);
        return formattedDate;
    }

    @Override
    public String toString() {
        return "name: " + this.getName() + "\t" +
            "birth date: " + this.getBirthDate() + "\t" +
            "registration date: " + this.getRegistrationDate() + "\t" +
            "rating: " + this.getRating();
    }
}