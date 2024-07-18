package com.konditer.blogus.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.entities.CommentReaction;
import com.konditer.blogus.entities.User;
import com.konditer.blogus.repositories.CommentReactionRepository;
import com.konditer.blogus.repositories.UserRepository;
import com.konditer.blogus.services.contracts.CommentReactionServiceContract;

@Service
public class CommentReactionService implements CommentReactionServiceContract {

    final double DEFAULT_REACTION_USER_RATING = 0.01;
    
    @Autowired
    private CommentReactionRepository commentReactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public CommentReaction getReactionById(int id) {
        return commentReactionRepository.findById(id).get();
    }

    @Override
    public List<CommentReaction> getAllReactions() {
        return commentReactionRepository.findAll();
    }

    @Override
    public void registerReaction(CommentReaction reaction) {
        User author = reaction.getAuthor();

        if (reaction.isPositive()) {
            author.setRating(author.getRating() + DEFAULT_REACTION_USER_RATING);
        } else {
            author.setRating(author.getRating() - DEFAULT_REACTION_USER_RATING);
        }

        userRepository.save(author);
        commentReactionRepository.save(reaction);
    }

    @Override
    public void removeReaction(int id) {
        CommentReaction reaction = commentReactionRepository.findById(id).get();
        User author = reaction.getAuthor();

        if (reaction.isPositive()) {
            author.setRating(author.getRating() - DEFAULT_REACTION_USER_RATING);
        } else {
            author.setRating(author.getRating() + DEFAULT_REACTION_USER_RATING);
        }

        userRepository.save(author);
        commentReactionRepository.delete(reaction);
    }

    @Override
    public void updateReactionPositive(int id, boolean positive) {
        CommentReaction reaction = commentReactionRepository.findById(id).get();
        reaction.setPositive(positive);
        reaction.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        commentReactionRepository.save(reaction);
    }

    @Override
    public List<CommentReaction> getReactionByCommentIdAndPositive(int id, boolean positive) {
        return commentReactionRepository.findByCommentIdAndPositive(id, positive);
    }
}
