package com.konditer.blogus.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.entities.PostReaction;
import com.konditer.blogus.repositories.PostReactionRepository;
import com.konditer.blogus.services.contracts.PostReactionServiceContract;

@Service
public class PostReactionService implements PostReactionServiceContract {
    
    @Autowired
    private PostReactionRepository postReactionRepository;

    @Override
    public PostReaction getReactionById(int id) {
        return postReactionRepository.findById(id);
    }

    @Override
    public List<PostReaction> getAllReactions() {
        return postReactionRepository.findAll();
    }

    @Override
    public void registerReaction(PostReaction reaction) {
        postReactionRepository.save(reaction);
    }

    @Override
    public void removeReaction(int id) {
        postReactionRepository.delete(postReactionRepository.findById(id));
    }

    @Override
    public void updateReactionPositive(int id, boolean positive) {
        PostReaction reaction = postReactionRepository.findById(id);
        reaction.setPositive(positive);
        reaction.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        postReactionRepository.save(reaction);
    }

    @Override
    public List<PostReaction> getReactionByCommentIdAndPositive(int id, boolean positive) {
        return postReactionRepository.findByPostIdAndPositive(id, positive);
    }
}
