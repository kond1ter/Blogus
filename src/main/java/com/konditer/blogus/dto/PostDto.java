package com.konditer.blogus.dto;

import java.sql.Timestamp;

public class PostDto {
    private int id;
    private String text;
    private String title;
    private String blogName;
    private String authorName;
    private int blogId;
    private int authorId;
    private int posReactionsAmount;
    private int negReactionsAmount;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public PostDto() {}

    public PostDto(
        String text,
        String title,
        int blogId,
        int authorId
    ) {
        this.text = text;
        this.title = title;
        this.blogId = blogId;
        this.authorId = authorId;
    }

    public PostDto(
        int id,
        String text, 
        String title, 
        String blogName,
        String authorName,
        int blogId, 
        int authorId,
        int posReactionsAmount, 
        int negReactionsAmount, 
        Timestamp createdAt, 
        Timestamp updatedAt
    ) {
        this.id = id;
        this.text = text;
        this.title = title;
        this.blogName = blogName;
        this.authorName = authorName;
        this.blogId = blogId;
        this.authorId = authorId;
        this.posReactionsAmount = posReactionsAmount;
        this.negReactionsAmount = negReactionsAmount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
