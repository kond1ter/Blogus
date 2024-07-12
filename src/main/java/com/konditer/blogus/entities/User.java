package com.konditer.blogus.entities;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity @Table(name = "user", schema = "public")
public class User extends BaseEntity {
    private String name;
    private LocalDate birthDate;
    private LocalDate registrationDate;
    private double rating;

    private Set<Blog> blogs;
    private Set<Comment> comments;
    private Set<UserSubscribe> subscribes;

    private static final double DEFAULT_RATING = 1.0;

    public User() {}

    public User(String name, LocalDate birthDate, LocalDate registrationDate, 
        Set<Blog> blogs, Set<Comment> comments, Set<UserSubscribe> subscribes) {
        this.setName(name);
        this.setBirthDate(birthDate);
        this.setRegistrationDate(LocalDate.now());
        this.setRating(DEFAULT_RATING);
        this.setBlogs(blogs);
        this.setComments(comments);
        this.setSubscribes(subscribes);
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

    @OneToMany(mappedBy = "author")
    public Set<Blog> getBlogs() {
        return this.blogs;
    }

    @OneToMany(mappedBy = "author")
    public Set<Comment> getComments() {
        return this.comments;
    }

    @OneToMany(mappedBy = "user")
    public Set<UserSubscribe> getSubscribes() {
        return this.subscribes;
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

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public void setSubscribes(Set<UserSubscribe> subscribes) {
        this.subscribes = subscribes;
    }
}