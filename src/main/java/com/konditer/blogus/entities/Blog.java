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
public class Blog extends BaseEntityUpdatable {

    private String name;
    private boolean closed;
    private double rating;

    private User author;
    private Theme theme;
    private List<UserSubscribe> subscribes;
    private List<BlogNote> notes;

    private static final double DEFAULT_RATING = 1.0;

    public Blog() {}

    public Blog(String name, User author, Theme theme, boolean closed) {
        super();
        this.name = name;
        this.closed = closed;
        this.rating = DEFAULT_RATING;
        this.author = author;
        this.theme = theme;
        this.subscribes = new ArrayList<>();
        this.notes = new ArrayList<>();
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
    public List<UserSubscribe> getSubscribes() {
        return this.subscribes;
    }

    @OneToMany(mappedBy = "blog")
    public List<BlogNote> getNotes() {
        return this.notes;
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

    public void setSubscribes(List<UserSubscribe> subscribes) {
        this.subscribes = subscribes;
    }

    public void setNotes(List<BlogNote> notes) {
        this.notes = notes;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }
}
