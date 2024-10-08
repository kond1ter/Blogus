package com.konditer.blogus.dto;

public class PostReactionDto {
    private boolean positive;
    private int authorId;
    private int postId;

    public PostReactionDto() {}

    public PostReactionDto(
        boolean positive, 
        int authorId, 
        int postId
    ) {
        this.positive = positive;
        this.authorId = authorId;
        this.postId = postId;
    }

    public boolean isPositive() {
        return positive;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
