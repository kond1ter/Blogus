package com.konditer.blogus.services.contracts;

import java.util.List;

import com.konditer.blogus.entities.PostReaction;

public interface PostReactionServiceContract {
    
    PostReaction getReactionById(int id);

    List<PostReaction> getAllReactions();

    List<PostReaction> getReactionByCommentIdAndPositive(int id, boolean positive);

    void registerReaction(PostReaction reaction);

    void removeReaction(int id);

    void updateReactionPositive(int id, boolean positive);
}
