package com.konditer.blogus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.konditer.blogus.services.CommentReactionService;

@RestController
public class CommentReactionController {
    
    @Autowired
    private CommentReactionService commentReactionService;
}
