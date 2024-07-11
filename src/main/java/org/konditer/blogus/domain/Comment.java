package org.konditer.blogus.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity @Table(name = "comment", schema = "public")
public class Comment extends BaseEntity {
    private LocalDate creatingDate;
    private String text;
    private int likesAmount;
    private int dislikesAmount;

    private User author;
    private BlogNote blogNote;

    public Comment() {}

    // public Comment(int userId, int blogId, String text) {
    //     this.setText(text);
    //     this.setCreatingDate(LocalDate.now());
    //     this.setLikesAmount(0);
    //     this.setDislikesAmount(0);
    // }

    @Column(name = "creating_date")
    public LocalDate getCreatingDate() {
        return creatingDate;
    }

    @Column(name = "text")
    public String getText() {
        return text;
    }

    @Column(name = "likes_amount")
    public int getLikesAmount() {
        return likesAmount;
    }

    @Column(name = "dislikes_amount")
    public int getDislikesAmount() {
        return dislikesAmount;
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

    public void setCreatingDate(LocalDate creadingDate) {
        this.creatingDate = creadingDate;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setLikesAmount(int likesAmount) {
        this.likesAmount = likesAmount;
    }

    public void setDislikesAmount(int dislikesAmount) {
        this.dislikesAmount = dislikesAmount;
    }

    public void setBlogNote(BlogNote blogNote) {
        this.blogNote = blogNote;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
