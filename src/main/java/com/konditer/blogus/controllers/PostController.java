package com.konditer.blogus.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.konditer.blogus.dto.PostDto;
import com.konditer.blogus.entities.Post;
import com.konditer.blogus.services.BlogService;
import com.konditer.blogus.services.PostReactionService;
import com.konditer.blogus.services.PostService;

@RestController
public class PostController {

    private PostDto mapPostntityToPostDto(Post post) {
        return new PostDto(post.getTitle(), post.getText(),
            postReactionService.getReactionByCommentIdAndPositive(
                post.getId(), true).size(),
            postReactionService.getReactionByCommentIdAndPositive(
                post.getId(), false).size(),
            post.getBlog().getId(), post.getCreatedAt(), post.getUpdatedAt());
    }

    private Post mapPostDtoToPostEntity(PostDto postDto) {
        return new Post(postDto.getTitle(), postDto.getText(),
            blogService.getBlogById(postDto.getBlogId()));
    }

    @Autowired
    private PostService postService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private PostReactionService postReactionService;

    @GetMapping("/posts/{id}")
    public PostDto getPostById(@PathVariable int id) {
        return mapPostntityToPostDto(postService.getPostById(id));
    }

    @GetMapping("/posts")
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts()
            .stream().map(c -> mapPostntityToPostDto(c))
            .collect(Collectors.toList());
    }

    @PostMapping("/posts/register")
    public void registerPost(@RequestBody PostDto postDto) {
        System.out.println(postDto);
        postService.registerPost(mapPostDtoToPostEntity(postDto));
    }
    
    @DeleteMapping("/posts/{id}")
    public void removePost(@PathVariable int id) {
        postService.removePost(id);
    }

    @GetMapping("/posts/{id}/updatePostTitle")
    public void updatePostTitle(@PathVariable int id, @RequestParam String title) {
        postService.updatePostTitle(id, title);
    }

    @GetMapping("/posts/{id}/updatePostText")
    public void updatePostText(@PathVariable int id, @RequestParam String text) {
        postService.updatePostText(id, text);
    }
}
