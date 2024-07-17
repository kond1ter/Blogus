package com.konditer.blogus.dto;

public class BlogDto {
    private String name;
    private boolean closed;
    private double rating;
    private int authorId;
    private int themeId;
    private int notesAmount;
    private int subscribesAmount;

    public BlogDto() {}

    public BlogDto(String name, boolean closed, int authorId, int themeId) {
        
        this.name = name;
        this.closed = closed;
        this.rating = 1;
        this.authorId = authorId;
        this.themeId = themeId;
        this.notesAmount = 0;
        this.subscribesAmount = 0;
    }

    public BlogDto(String name, boolean closed, double rating,
    int authorId, int themeId, int notesAmount, int subscribesAmount) {
        
        this.name = name;
        this.closed = closed;
        this.rating = rating;
        this.authorId = authorId;
        this.themeId = themeId;
        this.notesAmount = notesAmount;
        this.subscribesAmount = subscribesAmount;
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

    public int getNotesAmount() {
        return notesAmount;
    }

    public void setNotesAmount(int notesAmount) {
        this.notesAmount = notesAmount;
    }

    public int getSubscribesAmount() {
        return subscribesAmount;
    }

    public void setSubscribesAmount(int subscribesAmount) {
        this.subscribesAmount = subscribesAmount;
    }
}
