package com.konditer.blogus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.dto.CommentReactionDto;
import com.konditer.blogus.entities.CommentReaction;
import com.konditer.blogus.repositories.CommentReactionRepository;
import com.konditer.blogus.services.contracts.CommentReactionServiceContract;

@Service
public class CommentReactionService implements CommentReactionServiceContract {
    
    @Autowired
    private CommentReactionRepository commentReactionRepository;

    @Override
    public void register(CommentReactionDto reaction) {
        // TODO: implement rating changing
        commentReactionRepository.save(mapToEntity(reaction));
    }

    @Override
    public void remove(int id) {
        // TODO: implement rating changing
        // TODO: implement marking as deleted
    }

    private CommentReaction mapToEntity(CommentReactionDto reactionDto) {
        // TODO: implement mapper
        return new CommentReaction();
    }
}
