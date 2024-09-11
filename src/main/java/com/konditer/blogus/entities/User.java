package com.konditer.blogus.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity @Table(name = "user", schema = "public")
public class User extends BaseEntity {

    private String name;
    private LocalDate birthDate;
    private double rating;
    private List<Blog> blogs;
    private List<Comment> comments;
    private List<Subscribe> subscribes;

    private static final double DEFAULT_RATING = 0.0;

    public User() {}

    public User(String name, LocalDate birthDate) {
        super();
        this.name = name;
        this.birthDate = birthDate;
        this.rating = DEFAULT_RATING;
        this.blogs = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.subscribes = new ArrayList<>();
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    @Column(name = "birth_date")
    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    @Column(name = "rating")
    public double getRating() {
        return this.rating;
    }

    @OneToMany(mappedBy = "author")
    public List<Blog> getBlogs() {
        return this.blogs;
    }

    @OneToMany(mappedBy = "author")
    public List<Comment> getComments() {
        return this.comments;
    }

    @OneToMany(mappedBy = "user")
    public List<Subscribe> getSubscribes() {
        return this.subscribes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setSubscribes(List<Subscribe> subscribes) {
        this.subscribes = subscribes;
    }
}