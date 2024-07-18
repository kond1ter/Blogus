package com.konditer.blogus.services.contracts;

import java.util.List;

import com.konditer.blogus.entities.Comment;

public interface CommentServiceContract {
    
    Comment getCommentById(int id);

    List<Comment> getAllComments(int postId);

    void registerComment(Comment comment);

    void removeComment(int id);

    void updateCommentText(int id, String text);
}
