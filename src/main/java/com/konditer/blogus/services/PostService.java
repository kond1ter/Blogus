package com.konditer.blogus.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.dto.PostDto;
import com.konditer.blogus.entities.Blog;
import com.konditer.blogus.entities.Post;
import com.konditer.blogus.repositories.BlogRepository;
import com.konditer.blogus.repositories.PostReactionRepository;
import com.konditer.blogus.repositories.PostRepository;
import com.konditer.blogus.services.contracts.PostServiceContract;

@Service
public class PostService implements PostServiceContract {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private PostReactionRepository postReactionRepository;

    @Override
    public PostDto getPostById(int id) {
        return mapPostntityToPostDto(postRepository.findById(id).get());
    }

    @Override
    public List<PostDto> getAllPosts() {
        return postRepository.findAll()
            .stream().map(p -> mapPostntityToPostDto(p))
            .collect(Collectors.toList());
    }

    @Override
    public void registerPost(PostDto post) {
        Blog blog = blogRepository.findById(post.getBlogId()).get();
        blog.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        blogRepository.save(blog);
        postRepository.save(mapPostDtoToPostEntity(post));
    }

    @Override
    public void removePost(int id) {
        postRepository.deleteById(id);
    }

    @Override
    public void updatePostTitle(int id, String title) {
        Post post = postRepository.findById(id).get();
        post.setTitle(title);
        post.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        postRepository.save(post);
    }

    @Override
    public void updatePostText(int id, String text) {
        Post post = postRepository.findById(id).get();
        post.setText(text);
        post.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        postRepository.save(post);
    }

    private PostDto mapPostntityToPostDto(Post post) {
        return new PostDto(post.getTitle(), post.getText(),
            postReactionRepository.findByPostIdAndPositive(
                post.getId(), true).size(),
            postReactionRepository.findByPostIdAndPositive(
                post.getId(), false).size(),
            post.getBlog().getId(), post.getCreatedAt(), post.getUpdatedAt());
    }

    private Post mapPostDtoToPostEntity(PostDto postDto) {
        return new Post(postDto.getTitle(), postDto.getText(),
            blogRepository.findById(postDto.getBlogId()).get());
    }
}
