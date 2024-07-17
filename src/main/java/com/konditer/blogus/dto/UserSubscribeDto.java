package com.konditer.blogus.dto;

public class UserSubscribeDto {
    
    private int userId;
    private int blogId;
    private String userName;
    private String blogName;

    public UserSubscribeDto() {}

    public UserSubscribeDto(int userId, int blogId, String userName, String blogName) {
        this.userId = userId;
        this.blogId = blogId;
        this.userName = userName;
        this.blogName = blogName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }
}
