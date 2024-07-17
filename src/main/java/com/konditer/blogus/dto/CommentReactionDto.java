package com.konditer.blogus.dto;

import java.sql.Timestamp;

public class CommentReactionDto {

    private boolean positive;
    private int authorId;
    private int commentId;
    private String authorName;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public CommentReactionDto(boolean positive, int authorId, int commentId, 
    String authorName, Timestamp createdAt, Timestamp updatedAt) {

        this.positive = positive;
        this.authorId = authorId;
        this.commentId = commentId;
        this.authorName = authorName;
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

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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
