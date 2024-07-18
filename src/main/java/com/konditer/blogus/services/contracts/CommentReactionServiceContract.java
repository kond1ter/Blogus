package com.konditer.blogus.services.contracts;

import java.util.List;

import com.konditer.blogus.dto.CommentReactionDto;

public interface CommentReactionServiceContract {
    
    CommentReactionDto getReactionById(int id);

    List<CommentReactionDto> getAllReactions();

    // List<CommentReactionDto> getReactionByCommentIdAndPositive(int id, boolean positive);

    void registerReaction(CommentReactionDto reaction);

    void removeReaction(int id);

    void updateReactionPositive(int id, boolean positive);
}
