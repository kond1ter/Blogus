package org.konditer.blogus.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity @Table(name = "blog_note")
public class BlogNote extends BaseEntity {
    private int blogId;
    private String title;
    private String text;
    private LocalDate creatingDate;
    private int likesAmount;
    private int dislikesAmount;

    public BlogNote() {}

    public BlogNote(int blogId, String title, String text) {
        this.setBlogId(blogId);
        this.setTitle(title);
        this.setText(text);
        this.setCreatingDate(LocalDate.now());
    }

    @Column(name = "blog_id")
    public int getBlogId() {
        return blogId;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    @Column(name = "text")
    public String getText() {
        return text;
    }

    @Column(name = "creating_date")
    public LocalDate getCreatingDate() {
        return creatingDate;
    }

    @Column(name = "likes_amount")
    public int getLikesAmount() {
        return likesAmount;
    }

    @Column(name = "dislikes_amount")
    public int getDislikesAmount() {
        return dislikesAmount;
    }

    public void setDislikesAmount(int dislikesAmount) {
        this.dislikesAmount = dislikesAmount;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCreatingDate(LocalDate creatingDate) {
        this.creatingDate = creatingDate;
    }

    public void setLikesAmount(int likesAmount) {
        this.likesAmount = likesAmount;
    }
}
