package com.konditer.blogus.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.konditer.blogus.dto.CommentReactionDto;
import com.konditer.blogus.entities.CommentReaction;
import com.konditer.blogus.services.CommentReactionService;
import com.konditer.blogus.services.CommentService;
import com.konditer.blogus.services.UserService;

@RestController
public class CommentReactionController {

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
            userService.getUserById(reactionDto.getAuthorId()),
            commentService.getCommentById(reactionDto.getCommentId()));
    }
    
    @Autowired
    private CommentReactionService commentReactionService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/commentReactions/{id}")
    public CommentReactionDto getReactionById(@PathVariable int id) {
        return mapReactionEntityToReactionDto(
            commentReactionService.getReactionById(id));
    }

    @GetMapping("/commentReactions")
    public List<CommentReactionDto> getAllReactions() {
        return commentReactionService.getAllReactions().stream()
            .map(r -> mapReactionEntityToReactionDto(r))
            .collect(Collectors.toList());
    }

    @PostMapping("/commentReactions/register")
    public void registerReaction(@RequestBody CommentReactionDto reactionDto) {
        commentReactionService.registerReaction(
            mapReacionDtoToReactionEntity(reactionDto));
    }
    
    @DeleteMapping("/commentReactions/{id}")    
    public void removeReaction(@PathVariable int id) {
        commentReactionService.removeReaction(id);
    }
    
    @GetMapping("/commentReactions/{id}/updateReactionPositive")
    public void updateReactionPositive(@RequestParam boolean positive, @PathVariable int id) {
        commentReactionService.updateReactionPositive(id, positive);
    }
}
