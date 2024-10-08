package com.konditer.blogus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @PostMapping("/reactions/comment/register")
    public void register(@RequestBody CommentReactionDto reactionDto) {
        commentReactionService.register(reactionDto);
    }
    
    @DeleteMapping("/reactions/comment/remove")    
    public void remove(@RequestParam int id) {
        commentReactionService.remove(id);
    }
}
