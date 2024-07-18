package com.konditer.blogus.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.dto.CommentReactionDto;
import com.konditer.blogus.entities.CommentReaction;
import com.konditer.blogus.entities.User;
import com.konditer.blogus.repositories.CommentReactionRepository;
import com.konditer.blogus.repositories.CommentRepository;
import com.konditer.blogus.repositories.UserRepository;
import com.konditer.blogus.services.contracts.CommentReactionServiceContract;

@Service
public class CommentReactionService implements CommentReactionServiceContract {

    final double DEFAULT_REACTION_USER_RATING = 0.01;
    
    @Autowired
    private CommentReactionRepository commentReactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public CommentReactionDto getReactionById(int id) {
        return mapReactionEntityToReactionDto(commentReactionRepository.findById(id).get());
    }

    @Override
    public List<CommentReactionDto> getAllReactions() {
        return commentReactionRepository.findAll()
            .stream().map(c -> mapReactionEntityToReactionDto(c))
            .collect(Collectors.toList());
    }

    @Override
    public void registerReaction(CommentReactionDto reaction) {
        User author = userRepository.findById(reaction.getAuthorId()).get();

        if (reaction.isPositive()) {
            author.setRating(author.getRating() + DEFAULT_REACTION_USER_RATING);
        } else {
            author.setRating(author.getRating() - DEFAULT_REACTION_USER_RATING);
        }

        userRepository.save(author);
        commentReactionRepository.save(mapReacionDtoToReactionEntity(reaction));
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

    // @Override
    // public List<CommentReaction> getReactionByCommentIdAndPositive(int id, boolean positive) {
    //     return commentReactionRepository.findByCommentIdAndPositive(id, positive);
    // }

    private CommentReactionDto mapReactionEntityToReactionDto(CommentReaction reaction) {
        return new CommentReactionDto(reaction.isPositive(), 
            reaction.getAuthor().getId(), 
            reaction.getComment().getId(), 
            reaction.getAuthor().getName(), 
            reaction.getCreatedAt(), 
            reaction.getUpdatedAt());
    }

    private CommentReaction mapReacionDtoToReactionEntity(CommentReactionDto reactionDto) {
        return new CommentReaction(reactionDto.isPositive(),
            userRepository.findById(reactionDto.getAuthorId()).get(),
            commentRepository.findById(reactionDto.getCommentId()).get());
    }
}
