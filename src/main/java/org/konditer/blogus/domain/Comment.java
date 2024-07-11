package org.konditer.blogus.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity @Table(name = "comment", schema = "public")
public class Comment extends BaseEntity {
    private int userId;
    private int blogId;
    private LocalDate creatingDate;
    private String text;
    private int likesAmount;
    private int dislikesAmount;

    public Comment() {}

    public Comment(int userId, int blogId, String text) {
        this.setUserId(userId);
        this.setBlogId(blogId);
        this.setText(text);
        this.setCreatingDate(LocalDate.now());
        this.setLikesAmount(0);
        this.setDislikesAmount(0);
    }

    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    @Column(name = "blog_id")
    public int getBlogId() {
        return blogId;
    }

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

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
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
}
