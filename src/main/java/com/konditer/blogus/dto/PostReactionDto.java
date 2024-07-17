package com.konditer.blogus.dto;

import java.sql.Timestamp;

public class PostReactionDto {
    
    private boolean positive;
    private int authorId;
    private int postId;
    private String authorName;
    private String postName;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public PostReactionDto(boolean positive, int authorId, int postId, 
    String authorName, String postName, Timestamp createdAt, Timestamp updatedAt) {

        this.positive = positive;
        this.authorId = authorId;
        this.postId = postId;
        this.authorName = authorName;
        this.postName = postName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public boolean isPositive() {
        return positive;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
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
