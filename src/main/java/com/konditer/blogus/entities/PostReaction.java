package com.konditer.blogus.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity @Table(name = "blog_note_reaction", schema = "public")
public class PostReaction extends BaseEntity {
    
    private boolean positive;
    private User author;
    private Post post;

    public PostReaction(boolean positive, User author, Post post) {
        this.positive = positive;
        this.author = author;
        this.post = post;
    }

    public PostReaction() {}

    @Column(name = "is_positive")
    public boolean isPositive() {
        return positive;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    public User getAuthor() {
        return author;
    }

    @ManyToOne
    @JoinColumn(name = "blog_note_id", nullable = false)
    public Post getPost() {
        return post;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
