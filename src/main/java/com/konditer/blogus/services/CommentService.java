package com.konditer.blogus.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.entities.Comment;
import com.konditer.blogus.repositories.CommentRepository;
import com.konditer.blogus.services.contracts.CommentServiceContract;

@Service
public class CommentService implements CommentServiceContract {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment getCommentById(int id) {
        return commentRepository.findById(id);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public void registerComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void removeComment(int id) {
        commentRepository.delete(commentRepository.findById(id));
    }

    @Override
    public void updateCommentText(int id, String text) {
        Comment comment = commentRepository.findById(id);
        comment.setText(text);
        comment.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        commentRepository.save(comment);
    }
}
