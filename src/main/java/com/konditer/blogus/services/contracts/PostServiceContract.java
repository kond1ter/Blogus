package com.konditer.blogus.services.contracts;

import java.util.List;

import com.konditer.blogus.entities.Post;

public interface PostServiceContract {
    
    Post getPostById(int id);

    List<Post> getAllPosts();

    void registerPost(Post post);

    void removePost(int id);

    void updatePostTitle(int id, String title);

    void updatePostText(int id, String text);
}
