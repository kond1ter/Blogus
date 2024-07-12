package com.konditer.blogus.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity @Table(name = "user_subscribes", schema = "public")
public class UserSubscribe extends BaseEntity {
    private LocalDate subscribingDate;

    public User user;
    public Blog blog;

    public UserSubscribe() {}

    public UserSubscribe(LocalDate subscribingDate, User user, Blog blog) {
        this.setSubscribingDate(LocalDate.now());
        this.setUser(user);
        this.setBlog(blog);
    }

    @Column(name = "subscribing_date")
    public LocalDate getSubscribingDate() {
        return this.subscribingDate;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return this.user;
    }

    @ManyToOne
    @JoinColumn(name = "blog_id", nullable = false)
    public Blog getBlog() {
        return this.blog;
    }

    public void setSubscribingDate(LocalDate subscribingDate) {
        this.subscribingDate = subscribingDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
