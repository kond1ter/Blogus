package com.konditer.blogus.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity @Table(name = "comment", schema = "public")
public class Comment extends BaseEntityUpdatable {

    private String text;
    private int posReactionsAmount;
    private int negReactionsAmount;

    private User author;
    private BlogNote blogNote;

    public Comment() {}

    public Comment(String text, User author, BlogNote blogNote) {
        super();
        this.text = text;
        this.posReactionsAmount = 0;
        this.negReactionsAmount = 0;
        this.blogNote = blogNote;
        this.author = author;
    }

    @Column(name = "text")
    public String getText() {
        return text;
    }

    @Column(name = "pos_reactions_amount")
    public int getPosReactionsAmount() {
        return this.posReactionsAmount;
    }

    @Column(name = "neg_reactions_amount")
    public int negPosReactionsAmount() {
        return this.negReactionsAmount;
    }

    @ManyToOne
    @JoinColumn(name = "blog_note_id", nullable = false)
    public BlogNote getBlogNote() {
        return this.blogNote;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User getAuthor() {
        return this.author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setBlogNote(BlogNote blogNote) {
        this.blogNote = blogNote;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setPosReactionsAmount(int posReactionsAmount) {
        this.posReactionsAmount = posReactionsAmount;
    }

    public void setNegReactionsAmount(int negReactionsAmount) {
        this.negReactionsAmount = negReactionsAmount;
    }
}
