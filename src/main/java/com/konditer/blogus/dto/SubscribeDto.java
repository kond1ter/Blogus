package com.konditer.blogus.dto;

public class SubscribeDto {
    private int userId;
    private int blogId;

    public SubscribeDto() {}

    public SubscribeDto(
        int userId, 
        int blogId
    ) {
        this.userId = userId;
        this.blogId = blogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }
}
