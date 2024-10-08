package com.konditer.blogus.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.dto.PostReactionDto;
import com.konditer.blogus.entities.PostReaction;
import com.konditer.blogus.repositories.PostReactionRepository;
import com.konditer.blogus.services.contracts.PostReactionServiceContract;

@Service
public class PostReactionService implements PostReactionServiceContract {

    @Autowired
    private PostReactionRepository postReactionRepository;

    @Override
    public void register(PostReactionDto reaction) {
        // TODO: implement rating changing
        postReactionRepository.save(mapToEntity(reaction));
    }

    @Override
    public void remove(int id) {
        // TODO: implement rating changing
        // TODO: implement marking as deleted
    }

    private PostReaction mapToEntity(PostReactionDto reactionDto) {
        // TODO: implement mapper
        return new PostReaction();
    }
}
