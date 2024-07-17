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

import com.konditer.blogus.dto.CommentDto;
import com.konditer.blogus.entities.Comment;
import com.konditer.blogus.services.BlogNoteService;
import com.konditer.blogus.services.CommentService;
import com.konditer.blogus.services.UserService;

@RestController
public class CommentController {

    private CommentDto mapCommentEntityToCommentDto(Comment comment) {
        return new CommentDto(comment.getText(),
            comment.getPosReactionsAmount(), comment.getNegReactionsAmount(),
            comment.getAuthor().getId(), comment.getBlogNote().getId(),
            comment.getCreatedAt(), comment.getUpdatedAt());
    }

    private Comment mapCommentDtoToCommentEntity(CommentDto commentDto) {
        return new Comment(commentDto.getText(), 
            userService.getUserById(commentDto.getAuthorId()),
            blogNoteService.getBlogNoteById(commentDto.getBlogNoteId()));
    }

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private BlogNoteService blogNoteService;

    @GetMapping("/comments/{id}")
    public CommentDto getCommentById(@PathVariable int id) {
        return mapCommentEntityToCommentDto(commentService.getCommentById(id));
    }

    @GetMapping("/comments")
    public List<CommentDto> getAllComments() {
        return commentService.getAllComments()
            .stream().map(c -> mapCommentEntityToCommentDto(c))
            .collect(Collectors.toList());
    }

    @PostMapping("/comments/register")
    public void registerComment(@RequestBody CommentDto commentDto) {
        commentService.registerComment(mapCommentDtoToCommentEntity(commentDto));
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
