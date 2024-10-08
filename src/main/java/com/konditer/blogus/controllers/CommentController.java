package com.konditer.blogus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.konditer.blogus.dto.CommentDto;
import com.konditer.blogus.services.CommentService;

@RestController
public class CommentController {


    @Autowired
    private CommentService commentService;

    @GetMapping("/comments/allbypost")
    public List<CommentDto> getAllByPostId(@RequestParam int postid) {
        return commentService.getAllByPostId(postid);
    }

    @PostMapping("/comments/register")
    public void register(@RequestBody CommentDto commentDto) {
        commentService.register(commentDto);
    }
    
    @DeleteMapping("/comments/remove")
    public void remove(@RequestParam int id) {
        commentService.remove(id);
    }
}
