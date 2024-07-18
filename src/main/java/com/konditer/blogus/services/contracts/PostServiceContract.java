package com.konditer.blogus.services.contracts;

import java.util.List;

import com.konditer.blogus.dto.PostDto;

public interface PostServiceContract {
    
    PostDto getPostById(int id);

    List<PostDto> getAllPosts();

    void registerPost(PostDto post);

    void removePost(int id);

    void updatePostTitle(int id, String title);

    void updatePostText(int id, String text);
}
