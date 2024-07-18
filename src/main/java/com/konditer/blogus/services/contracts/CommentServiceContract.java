package com.konditer.blogus.services.contracts;

import java.util.List;

import com.konditer.blogus.dto.CommentDto;

public interface CommentServiceContract {
    
    CommentDto getCommentById(int id);

    List<CommentDto> getAllComments(int postId);

    void registerComment(CommentDto comment);

    void removeComment(int id);

    void updateCommentText(int id, String text);
}
