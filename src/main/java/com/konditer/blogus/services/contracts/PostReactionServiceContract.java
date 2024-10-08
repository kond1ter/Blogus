package com.konditer.blogus.services.contracts;

import com.konditer.blogus.dto.PostReactionDto;

public interface PostReactionServiceContract {
    
    void register(PostReactionDto reaction);

    void remove(int id);
}
