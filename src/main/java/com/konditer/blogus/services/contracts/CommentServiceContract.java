package com.konditer.blogus.services.contracts;

import java.util.List;

import com.konditer.blogus.dto.CommentDto;

public interface CommentServiceContract {
    
    List<CommentDto> getAllByPostId(int id);

    void register(CommentDto comment);

    void remove(int id);
}
