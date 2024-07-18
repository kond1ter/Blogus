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

import com.konditer.blogus.dto.CommentDto;
import com.konditer.blogus.services.CommentService;

@RestController
public class CommentController {


    @Autowired
    private CommentService commentService;

    @GetMapping("/comments/{id}")
    public CommentDto getCommentById(@PathVariable int id) {
        return commentService.getCommentById(id);
    }

    @GetMapping("/comments")
    public List<CommentDto> getAllComments(@RequestParam int postId) {
        return commentService.getAllComments(postId);
    }

    @PostMapping("/comments/register")
    public void registerComment(@RequestBody CommentDto commentDto) {
        commentService.registerComment(commentDto);
    }
    
    @DeleteMapping("/comments/{id}")
    public void removeComment(@PathVariable int id) {
        commentService.removeComment(id);
    }

    @GetMapping("/comment/{id}/updateCommentText")
    public void updateCommentText(@PathVariable int id, @RequestParam String text) {
        commentService.updateCommentText(id, text);
    }
}
