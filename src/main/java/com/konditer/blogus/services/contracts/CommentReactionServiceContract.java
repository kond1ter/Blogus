package com.konditer.blogus.services.contracts;

import java.util.List;

import com.konditer.blogus.entities.CommentReaction;

public interface CommentReactionServiceContract {
    
    CommentReaction getReactionById(int id);

    List<CommentReaction> getAllReactions();

    List<CommentReaction> getReactionByCommentIdAndPositive(int id, boolean positive);

    void registerReaction(CommentReaction reaction);

    void removeReaction(int id);

    void updateReactionPositive(int id, boolean positive);
}
