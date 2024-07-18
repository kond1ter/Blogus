package com.konditer.blogus.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.konditer.blogus.dto.PostReactionDto;
import com.konditer.blogus.entities.PostReaction;
import com.konditer.blogus.services.PostReactionService;
import com.konditer.blogus.services.PostService;
import com.konditer.blogus.services.UserService;

@RestController
public class PostReactionController {

    private PostReactionDto mapReactionEntityToReactionDto(PostReaction reaction) {
        return new PostReactionDto(reaction.isPositive(), 
            reaction.getAuthor().getId(), 
            reaction.getPost().getId(), 
            reaction.getAuthor().getName(), 
            reaction.getPost().getTitle(),
            reaction.getCreatedAt(), 
            reaction.getUpdatedAt());
    }

    private PostReaction mapReacionDtoToReactionEntity(PostReactionDto reactionDto) {
        return new PostReaction(reactionDto.isPositive(),
            userService.getUserById(reactionDto.getAuthorId()),
            postService.getPostById(reactionDto.getPostId()));
    }
    
    @Autowired
    private PostReactionService postReactionService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping("/postReactions/{id}")
    public PostReactionDto getReactionById(@PathVariable int id) {
        return mapReactionEntityToReactionDto(
            postReactionService.getReactionById(id));
    }

    @GetMapping("/postReactions")
    public List<PostReactionDto> getAllReactions() {
        return postReactionService.getAllReactions().stream()
            .map(r -> mapReactionEntityToReactionDto(r))
            .collect(Collectors.toList());
    }

    @PostMapping("/postReactions/register")
    public void registerReaction(@RequestBody PostReactionDto reactionDto) throws NotFoundException {
        postReactionService.registerReaction(
            mapReacionDtoToReactionEntity(reactionDto));
    }
    
    @DeleteMapping("/postReactions/{id}")    
    public void removeReaction(@PathVariable int id) {
        postReactionService.removeReaction(id);
    }
}
