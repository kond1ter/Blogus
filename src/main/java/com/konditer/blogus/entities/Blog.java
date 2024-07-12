package com.konditer.blogus.entities;

import java.time.LocalDate;
import java.util.Set;

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
    private LocalDate creatingDate;
    private double rating;

    private User author;
    private Theme theme;
    private Set<UserSubscribe> subscribes;
    private Set<BlogNote> notes;

    private static final double DEFAULT_RATING = 1.0;

    public Blog() {}

    public Blog(String name, boolean closed, User author, Theme theme,
        Set<UserSubscribe> subscribes, Set<BlogNote> notes) {
        this.setName(name);
        this.setClosed(closed);
        this.setCreatingDate(LocalDate.now());
        this.setRating(DEFAULT_RATING);
        this.setAuthor(author);
        this.setTheme(theme);
        this.setSubscribes(subscribes);
        this.setNotes(notes);
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    @Column(name = "is_private")
    public boolean isClosed() {
        return this.closed;
    }

    @Column(name = "creating_date")
    public LocalDate getCreatingDate() {
        return this.creatingDate;
    }

    @Column(name = "rating")
    public double getRating() {
        return this.rating;
    }

    @OneToMany(mappedBy = "blog")
    public Set<UserSubscribe> getSubscribes() {
        return this.subscribes;
    }

    @OneToMany(mappedBy = "blog")
    public Set<BlogNote> getNotes() {
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

    public void setCreatingDate(LocalDate creatingDate) {
        this.creatingDate = creatingDate;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setSubscribes(Set<UserSubscribe> subscribes) {
        this.subscribes = subscribes;
    }

    public void setNotes(Set<BlogNote> notes) {
        this.notes = notes;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }
}
