package com.konditer.blogus.services.contracts;

import java.util.List;

import com.konditer.blogus.dto.PostDto;

public interface PostServiceContract {
    
    PostDto get(int id);

    List<PostDto> getAllByBlogId(int id);

    void register(PostDto post);

    void remove(int id);
}
