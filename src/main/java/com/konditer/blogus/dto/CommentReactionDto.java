package com.konditer.blogus.dto;

public class CommentReactionDto {
    private boolean positive;
    private int authorId;
    private int commentId;

    public CommentReactionDto() {}

    public CommentReactionDto(
        boolean positive, 
        int authorId, 
        int commentId
    ) {
        this.positive = positive;
        this.authorId = authorId;
        this.commentId = commentId;
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

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }
}
