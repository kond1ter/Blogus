package com.konditer.blogus.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity @Table(name = "comment", schema = "public")
public class Comment extends BaseEntity {

    private String text;
    private User author;
    private Post post;
    private List<CommentReaction> reactions;

    public Comment() {}

    public Comment(String text, User author, Post post) {
        super();
        this.text = text;
        this.post = post;
        this.author = author;
        this.reactions = new ArrayList<>();
    }

    @Column(name = "text")
    public String getText() {
        return text;
    }

    @OneToMany(mappedBy = "comment")
    public List<CommentReaction> getReactions() {
        return this.reactions;
    }

    @ManyToOne
    @JoinColumn(name = "blog_note_id", nullable = false)
    public Post getPost() {
        return this.post;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User getAuthor() {
        return this.author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setReactions(List<CommentReaction> reactions) {
        this.reactions = reactions;
    }
}
