package com.konditer.blogus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.konditer.blogus.dto.PostDto;
import com.konditer.blogus.services.PostService;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts/{id}")
    public PostDto getPostById(@PathVariable int id) {
        return postService.getPostById(id);
    }

    @GetMapping("/posts")
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping("/posts/register")
    public void registerPost(@RequestBody PostDto postDto) {
        System.out.println(postDto);
        postService.registerPost(postDto);
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
