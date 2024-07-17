package com.konditer.blogus.dto;

import java.sql.Timestamp;

public class BlogDto {

    private String name;
    private boolean closed;
    private double rating;
    private int authorId;
    private int themeId;
    private int postsAmount;
    private int subscribesAmount;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public BlogDto() {}

    public BlogDto(String name, boolean closed, double rating, 
    int authorId, int themeId, int postsAmount, int subscribesAmount,
    Timestamp createdAt, Timestamp updatedAt) {
        
        this.name = name;
        this.closed = closed;
        this.rating = rating;
        this.authorId = authorId;
        this.themeId = themeId;
        this.postsAmount = postsAmount;
        this.subscribesAmount = subscribesAmount;
        this.createdAt = createdAt;
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    public int getPostsAmount() {
        return postsAmount;
    }

    public void setPostsAmount(int notesAmount) {
        this.postsAmount = notesAmount;
    }

    public int getSubscribesAmount() {
        return subscribesAmount;
    }

    public void setSubscribesAmount(int subscribesAmount) {
        this.subscribesAmount = subscribesAmount;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
