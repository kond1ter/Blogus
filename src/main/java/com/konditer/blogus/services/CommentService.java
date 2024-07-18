package com.konditer.blogus.services;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.dto.CommentDto;
import com.konditer.blogus.entities.Comment;
import com.konditer.blogus.repositories.CommentReactionRepository;
import com.konditer.blogus.repositories.CommentRepository;
import com.konditer.blogus.repositories.PostRepository;
import com.konditer.blogus.repositories.UserRepository;
import com.konditer.blogus.services.contracts.CommentServiceContract;

@Service
public class CommentService implements CommentServiceContract {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentReactionRepository commentReactionRepository;

    @Override
    public CommentDto getCommentById(int id) {
        return mapCommentEntityToCommentDto(commentRepository.findById(id).get());
    }

    @Override
    public List<CommentDto> getAllComments(int postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);

        Collections.sort(comments, (c1, c2) -> Integer.compare(
            c1.getReactions().size(), c2.getReactions().size()));

        return comments.stream()
            .map(c -> mapCommentEntityToCommentDto(c))
            .collect(Collectors.toList());
    }

    @Override
    public void registerComment(CommentDto comment) {
        commentRepository.save(mapCommentDtoToCommentEntity(comment));
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

    private CommentDto mapCommentEntityToCommentDto(Comment comment) {
        return new CommentDto(comment.getText(),
            commentReactionRepository.findByCommentIdAndPositive(
                comment.getId(), true).size(), 
            commentReactionRepository.findByCommentIdAndPositive(
                comment.getId(), false).size(),
            comment.getAuthor().getId(), comment.getPost().getId(),
            comment.getCreatedAt(), comment.getUpdatedAt());
    }

    private Comment mapCommentDtoToCommentEntity(CommentDto commentDto) {
        return new Comment(commentDto.getText(), 
            userRepository.findById(commentDto.getAuthorId()).get(),
            postRepository.findById(commentDto.getPostId()).get());
    }
}
