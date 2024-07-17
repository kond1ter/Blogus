package com.konditer.blogus.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.entities.Post;
import com.konditer.blogus.repositories.PostRepository;
import com.konditer.blogus.services.contracts.PostServiceContract;

@Service
public class PostService implements PostServiceContract {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post getPostById(int id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public void registerPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void removePost(int id) {
        postRepository.delete(postRepository.findById(id));
    }

    @Override
    public void updatePostTitle(int id, String title) {
        Post post = postRepository.findById(id);
        post.setTitle(title);
        post.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        postRepository.save(post);
    }

    @Override
    public void updatePostText(int id, String text) {
        Post post = postRepository.findById(id);
        post.setText(text);
        post.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        postRepository.save(post);
    }
    
}
