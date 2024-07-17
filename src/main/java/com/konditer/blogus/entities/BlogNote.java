package com.konditer.blogus.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity @Table(name = "blog_note")
public class BlogNote extends BaseEntityUpdatable {

    private String title;
    private String text;
    private int posReactionsAmount;
    private int negReactionsAmount;

    private Blog blog;
    private List<Comment> comments;

    public BlogNote() {}

    public BlogNote(String title, String text, Blog blog) {
        super();
        this.title = title;
        this.text = text;
        this.posReactionsAmount = 0;
        this.negReactionsAmount = 0;
        this.blog = blog;
        this.comments = new ArrayList<>();
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
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

    @OneToMany(mappedBy = "blogNote")
    public List<Comment> getComments() {
        return this.comments;
    }

    @ManyToOne
    @JoinColumn(name = "blog_id", nullable = false)
    public Blog getBlog() {
        return this.blog;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public void setPosReactionsAmount(int posReactionsAmount) {
        this.posReactionsAmount = posReactionsAmount;
    }

    public void setNegReactionsAmount(int negReactionsAmount) {
        this.negReactionsAmount = negReactionsAmount;
    }
}
