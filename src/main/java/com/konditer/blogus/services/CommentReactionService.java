package com.konditer.blogus.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.entities.CommentReaction;
import com.konditer.blogus.repositories.CommentReactionRepository;
import com.konditer.blogus.services.contracts.CommentReactionServiceContract;

@Service
public class CommentReactionService implements CommentReactionServiceContract {
    
    @Autowired
    private CommentReactionRepository commentReactionRepository;

    @Override
    public CommentReaction getReactionById(int id) {
        return commentReactionRepository.findById(id);
    }

    @Override
    public List<CommentReaction> getAllReactions() {
        return commentReactionRepository.findAll();
    }

    @Override
    public void registerReaction(CommentReaction reaction) {
        commentReactionRepository.save(reaction);
    }

    @Override
    public void removeReaction(int id) {
        commentReactionRepository.delete(commentReactionRepository.findById(id));
    }

    @Override
    public void updateReactionPositive(int id, boolean positive) {
        CommentReaction reaction = commentReactionRepository.findById(id);
        reaction.setPositive(positive);
        reaction.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        commentReactionRepository.save(reaction);
    }

    @Override
    public List<CommentReaction> getReactionByCommentIdAndPositive(int id, boolean positive) {
        return commentReactionRepository.findByCommentIdAndPositive(id, positive);
    }
}
