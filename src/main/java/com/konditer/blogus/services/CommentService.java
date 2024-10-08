package com.konditer.blogus.services;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.dto.CommentDto;
import com.konditer.blogus.entities.Comment;
import com.konditer.blogus.repositories.CommentRepository;
import com.konditer.blogus.services.contracts.CommentServiceContract;

@Service
public class CommentService implements CommentServiceContract {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<CommentDto> getAllByPostId(int id) {
        // TODO: implement and checks
        return commentRepository.findAll().stream()
            .map(c -> mapToDto(c))
            .collect(Collectors.toList());
    }

    @Override
    public void register(CommentDto comment) {
        // TODO: checks
        commentRepository.save(mapToEntity(comment));
    }

    @Override
    public void remove(int id) {
        // TODO: checks
        // TODO: implement marking as deleted
    }

    private CommentDto mapToDto(Comment comment) {
        // TODO: implement mapper
        return new CommentDto();
    }

    private Comment mapToEntity(CommentDto commentDto) {
        // TODO: implement mapper
        return new Comment();
    }
}
