package com.konditer.blogus.dto;

import java.sql.Timestamp;

public class CommentDto {
    private int id;
    private String text;
    private String authorName;
    private int authorId;
    private int postId;
    private int posReactionsAmount;
    private int negReactionsAmount;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public CommentDto() {}

    public CommentDto(
        String text,
        int postId,
        int authorId
    ) {
        this.text = text;
        this.postId = postId;
        this.authorId = authorId;
    }

    public CommentDto(
        int id,
        String text, 
        String authorName,
        int authorId, 
        int postId,
        int posReactionsAmount,
        int negReactionsAmount,
        Timestamp createdAt, 
        Timestamp updatedAt
    ) {
        this.id = id;
        this.text = text;
        this.authorName = authorName;
        this.authorId = authorId;
        this.postId = postId;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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
}
