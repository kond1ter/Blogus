package com.konditer.blogus.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity @Table(name = "blog_note", schema = "public")
public class Post extends BaseEntityUpdatable {

    private String title;
    private String text;
    private Blog blog;
    private List<Comment> comments;
    private List<PostReaction> reactions;

    public Post() {}

    public Post(String title, String text, Blog blog) {
        super();
        this.title = title;
        this.text = text;
        this.blog = blog;
        this.comments = new ArrayList<>();
        this.reactions = new ArrayList<>();
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    @Column(name = "text")
    public String getText() {
        return text;
    }

    @OneToMany(mappedBy = "post")
    public List<Comment> getComments() {
        return this.comments;
    }

    @OneToMany(mappedBy = "post")
    public List<PostReaction> getReactions() {
        return this.reactions;
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

    public void setReactions(List<PostReaction> reactions) {
        this.reactions = reactions;
    }
}
