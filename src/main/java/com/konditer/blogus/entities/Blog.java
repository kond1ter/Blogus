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

    private String name;
    private boolean closed;
    private double rating;

    private User author;
    private Theme theme;
    private List<Subscribe> subscribes;
    private List<Post> posts;

    private static final double DEFAULT_RATING = 0.0;

    public Blog() {}

    public Blog(String name, User author, Theme theme, boolean closed) {
        super();
        this.name = name;
        this.closed = closed;
        this.rating = DEFAULT_RATING;
        this.author = author;
        this.theme = theme;
        this.subscribes = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    @Column(name = "is_private")
    public boolean isClosed() {
        return this.closed;
    }

    @Column(name = "rating")
    public double getRating() {
        return this.rating;
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

    public void setClosed(boolean closed) {
        this.closed = closed;
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
}
