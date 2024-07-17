package com.konditer.blogus.dto;

import java.sql.Timestamp;

public class PostDto {

    private String text;
    private String title;
    private int posReactionsAmount;
    private int negReactionsAmount;
    private int blogId;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public PostDto(String title, String text, 
    int posReactionsAmount, int negReactionsAmount, 
    int blogId, Timestamp createdAt, Timestamp updatedAt) {

        this.text = text;
        this.title = title;
        this.posReactionsAmount = posReactionsAmount;
        this.negReactionsAmount = negReactionsAmount;
        this.blogId = blogId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public PostDto() {}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPosReactionsAmount() {
        return posReactionsAmount;
    }

    public void setPosReactionsAmount(int posReactionsAmount) {
        this.posReactionsAmount = posReactionsAmount;
    }

    public int getNegReactionsAmount() {
        return negReactionsAmount;
    }

    public void setNegReactionsAmount(int negReactionsAmount) {
        this.negReactionsAmount = negReactionsAmount;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
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
