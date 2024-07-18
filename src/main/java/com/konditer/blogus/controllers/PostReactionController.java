package com.konditer.blogus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.konditer.blogus.dto.PostReactionDto;
import com.konditer.blogus.services.PostReactionService;

@RestController
public class PostReactionController {
    
    @Autowired
    private PostReactionService postReactionService;

    @GetMapping("/postReactions/{id}")
    public PostReactionDto getReactionById(@PathVariable int id) {
        return postReactionService.getReactionById(id);
    }

    @GetMapping("/postReactions")
    public List<PostReactionDto> getAllReactions() {
        return postReactionService.getAllReactions();
    }

    @PostMapping("/postReactions/register")
    public void registerReaction(@RequestBody PostReactionDto reactionDto) {
        postReactionService.registerReaction(reactionDto);
    }
    
    @DeleteMapping("/postReactions/{id}")    
    public void removeReaction(@PathVariable int id) {
        postReactionService.removeReaction(id);
    }
}
