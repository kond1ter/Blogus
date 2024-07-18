package com.konditer.blogus.services;

import java.sql.Timestamp;
import java.util.Collections;
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
        return commentRepository.findById(id).get();
    }

    @Override
    public List<Comment> getAllComments(int postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);

        Collections.sort(comments, (c1, c2) -> Integer.compare(
            c1.getReactions().size(), c2.getReactions().size()));

        return comments;
    }

    @Override
    public void registerComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void removeComment(int id) {
        commentRepository.delete(commentRepository.findById(id).get());
    }

    @Override
    public void updateCommentText(int id, String text) {
        Comment comment = commentRepository.findById(id).get();
        comment.setText(text);
        comment.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        commentRepository.save(comment);
    }
}
