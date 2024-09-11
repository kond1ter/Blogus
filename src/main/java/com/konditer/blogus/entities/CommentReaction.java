package com.konditer.blogus.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity @Table(name = "comment_reaction", schema = "public")
public class CommentReaction extends BaseEntity {

    private boolean positive;
    private User author;
    private Comment comment;

    public CommentReaction(boolean positive, User author, Comment comment) {
        super();
        this.positive = positive;
        this.author = author;
        this.comment = comment;
    }

    public CommentReaction() {}

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
    @JoinColumn(name = "comment_id", nullable = false)
    public Comment getComment() {
        return comment;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
