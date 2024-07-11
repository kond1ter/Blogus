package org.konditer.blogus.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity @Table(name = "user_subscribes", schema = "public")
public class UserSubscribes extends BaseEntity {
    private int userId;
    private int blogId;
    private LocalDate subscribingDate;

    public UserSubscribes() {}

    public UserSubscribes(int userId, int blogId) {
        this.setUserId(userId);
        this.setBlogId(blogId);
        this.setSubscribingDate(LocalDate.now());
    }

    @Column(name = "user_id")
    public int getUserId() {
        return this.userId;
    }

    @Column(name = "blog_id")
    public int getBlogId() {
        return this.blogId;
    }

    @Column(name = "subscribing_date")
    public LocalDate getSubscribingDate() {
        return this.subscribingDate;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public void setSubscribingDate(LocalDate subscribingDate) {
        this.subscribingDate = subscribingDate;
    }
}
