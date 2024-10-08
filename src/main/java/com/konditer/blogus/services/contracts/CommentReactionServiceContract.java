package com.konditer.blogus.services.contracts;

import com.konditer.blogus.dto.CommentReactionDto;

public interface CommentReactionServiceContract {
    
    void register(CommentReactionDto reaction);

    void remove(int id);
}
