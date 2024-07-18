package com.konditer.blogus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.konditer.blogus.dto.CommentReactionDto;
import com.konditer.blogus.services.CommentReactionService;

@RestController
public class CommentReactionController {

    @Autowired
    private CommentReactionService commentReactionService;

    @GetMapping("/commentReactions/{id}")
    public CommentReactionDto getReactionById(@PathVariable int id) {
        return commentReactionService.getReactionById(id);
    }

    @GetMapping("/commentReactions")
    public List<CommentReactionDto> getAllReactions() {
        return commentReactionService.getAllReactions();
    }

    @PostMapping("/commentReactions/register")
    public void registerReaction(@RequestBody CommentReactionDto reactionDto) {
        commentReactionService.registerReaction(reactionDto);
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
