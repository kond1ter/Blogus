package com.konditer.blogus.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity @Table(name = "blog", schema = "public")
public class Blog extends BaseEntity {

    private static final double DEFAULT_RATING = 1.0;

    private String name;
    private String description;
    private User author;
    private Theme theme;
    private double rating;
    private double velocity;
    private List<Subscribe> subscribes;
    private List<Post> posts;

    public Blog() {}

    public Blog(
        String name, 
        String description,
        User author, 
        Theme theme
    ) {
        super();
        this.name = name;
        this.description = description;
        this.author = author;
        this.theme = theme;
        this.rating = DEFAULT_RATING;
        this.velocity = 0;
        this.subscribes = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @Column(name = "rating")
    public double getRating() {
        return this.rating;
    }

    @Column(name = "velocity")
    public double getVelocity() {
        return velocity;
    }

    @OneToMany(mappedBy = "blog")
    public List<Subscribe> getSubscribes() {
        return this.subscribes;
    }

    @OneToMany(mappedBy = "blog")
    public List<Post> getPosts() {
        return this.posts;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    public User getAuthor() {
        return this.author;
    }

    @ManyToOne
    @JoinColumn(name = "theme_id", nullable = false)
    public Theme getTheme() {
        return this.theme;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setSubscribes(List<Subscribe> subscribes) {
        this.subscribes = subscribes;
    }

    public void setPosts(List<Post> notes) {
        this.posts = notes;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public static double getDefaultRating() {
        return DEFAULT_RATING;
    }
}
