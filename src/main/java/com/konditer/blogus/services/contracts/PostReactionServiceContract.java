package com.konditer.blogus.services.contracts;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.konditer.blogus.entities.PostReaction;

public interface PostReactionServiceContract {
    
    PostReaction getReactionById(int id);

    List<PostReaction> getAllReactions();

    List<PostReaction> getReactionByCommentIdAndPositive(int id, boolean positive);

    void registerReaction(PostReaction reaction) throws NotFoundException;

    void removeReaction(int id);
}
