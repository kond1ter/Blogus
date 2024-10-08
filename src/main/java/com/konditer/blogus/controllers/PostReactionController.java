package com.konditer.blogus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.konditer.blogus.dto.PostReactionDto;
import com.konditer.blogus.services.PostReactionService;

@RestController
public class PostReactionController {
    
    @Autowired
    private PostReactionService postReactionService;

    @PostMapping("/reactions/post/register")
    public void register(@RequestBody PostReactionDto reactionDto) {
        postReactionService.register(reactionDto);
    }
    
    @DeleteMapping("/reactions/post/remove")    
    public void remove(@RequestParam int id) {
        postReactionService.remove(id);
    }
}
