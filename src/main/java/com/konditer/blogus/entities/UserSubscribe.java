package com.konditer.blogus.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity @Table(name = "user_subscribes", schema = "public")
public class UserSubscribe extends BaseEntity {

    public User user;
    public Blog blog;

    public UserSubscribe() {}

    public UserSubscribe(User user, Blog blog) {
        super();
        this.user = user;
        this.blog = blog;
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

    public void setUser(User user) {
        this.user = user;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
