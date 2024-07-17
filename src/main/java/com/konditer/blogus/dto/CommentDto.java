package com.konditer.blogus.dto;

import java.sql.Timestamp;

public class CommentDto {

    private String text;
    private int posReactionsAmount;
    private int negReactionsAmount;
    private int authorId;
    private int blogNoteId;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public CommentDto() {}

    public CommentDto(String text, int authorId, int blogNoteId,
    int posReactionsAmount, int negReactionsAmount,
    Timestamp createdAt, Timestamp updatedAt) {
        
        this.text = text;
        this.posReactionsAmount = posReactionsAmount;
        this.negReactionsAmount = posReactionsAmount;
        this.authorId = authorId;
        this.blogNoteId = blogNoteId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getBlogNoteId() {
        return blogNoteId;
    }

    public void setBlogNoteId(int blogNoteId) {
        this.blogNoteId = blogNoteId;
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
