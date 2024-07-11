package org.konditer.blogus.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity @Table(name = "user_subscribes", schema = "public")
public class UserSubscribes extends BaseEntity {
    private LocalDate subscribingDate;

    public User user;
    public Blog blog;

    public UserSubscribes() {}

    // public UserSubscribes(int userId, int blogId) {
    //     this.setUserId(userId);
    //     this.setBlogId(blogId);
    //     this.setSubscribingDate(LocalDate.now());
    // }

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
