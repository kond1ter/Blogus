package org.konditer.blogus.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity @Table(name = "blog", schema = "public")
public class Blog extends BaseEntity {
    private int authorId;
    private String name;
    private boolean closed;
    private LocalDate creatingDate;
    private double rating;
    private static final double DEFAULT_RATING = 1.0;

    public Blog() {}

    public Blog(int authorId, String name, boolean closed) {
        this.setAuthorId(authorId);
        this.setName(name);
        this.setClosed(closed);
        this.setCreatingDate(LocalDate.now());
        this.setRating(DEFAULT_RATING);
    }

    @Column(name = "author_id")
    public int getAuthorId() {
        return this.authorId;
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

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
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

    @Override
    public String toString() {
        return "author id: " + this.getAuthorId() +
            "name: " + this.getName() + 
            "is closed: " + this.isClosed() + 
            "creating date: " + this.getCreatingDate() +
            "rating: " + this.getRating();
    }
}
