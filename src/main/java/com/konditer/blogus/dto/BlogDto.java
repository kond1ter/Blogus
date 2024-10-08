package com.konditer.blogus.dto;

import java.sql.Timestamp;

public class BlogDto {
    private int id;
    private String name;
    private String authorName;
    private String themeName;
    private int authorId;
    private int themeId;
    private int postsAmount;
    private int subscribesAmount;
    private double rating;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public BlogDto() {}

    public BlogDto(
        String name,
        int authorId,
        int themeId
    ) {
        this.name = name;
        this.authorId = authorId;
        this.themeId = themeId;
    }

    public BlogDto(
        int id,
        String name, 
        String authorName,
        String themeName,
        int authorId, 
        int themeId, 
        int postsAmount, 
        int subscribesAmount,
        double rating, 
        Timestamp createdAt,
        Timestamp updatedAt
    ) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
        this.themeName = themeName;
        this.authorId = authorId;
        this.themeId = themeId;
        this.postsAmount = postsAmount;
        this.subscribesAmount = subscribesAmount;
        this.rating = rating;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
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

    public void setPostsAmount(int postsAmount) {
        this.postsAmount = postsAmount;
    }

    public int getSubscribesAmount() {
        return subscribesAmount;
    }

    public void setSubscribesAmount(int subscribesAmount) {
        this.subscribesAmount = subscribesAmount;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
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
