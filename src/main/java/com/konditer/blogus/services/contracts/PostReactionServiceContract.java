package com.konditer.blogus.services.contracts;

import java.util.List;

import com.konditer.blogus.dto.PostReactionDto;

public interface PostReactionServiceContract {
    
    PostReactionDto getReactionById(int id);

    List<PostReactionDto> getAllReactions();

    List<PostReactionDto> getReactionByCommentIdAndPositive(int id, boolean positive);

    void registerReaction(PostReactionDto reaction);

    void removeReaction(int id);
}
