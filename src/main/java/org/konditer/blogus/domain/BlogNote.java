package org.konditer.blogus.domain;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity @Table(name = "blog_note")
public class BlogNote extends BaseEntity {
    private String title;
    private String text;
    private LocalDate creatingDate;
    private int likesAmount;
    private int dislikesAmount;

    private Blog blog;
    private Set<Comment> comments;

    public BlogNote() {}

    // public BlogNote(int blogId, String title, String text) {
    //     this.setBlogId(blogId);
    //     this.setTitle(title);
    //     this.setText(text);
    //     this.setCreatingDate(LocalDate.now());
    // }

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

    @OneToMany(mappedBy = "blogNote")
    public Set<Comment> getComments() {
        return this.comments;
    }

    @ManyToOne
    @JoinColumn(name = "blog_id", nullable = false)
    public Blog getBlog() {
        return this.blog;
    }

    public void setDislikesAmount(int dislikesAmount) {
        this.dislikesAmount = dislikesAmount;
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

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
