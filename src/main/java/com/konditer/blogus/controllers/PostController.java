package com.konditer.blogus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/posts/one")
    public PostDto get(@RequestParam int id) {
        return postService.get(id);
    }

    @GetMapping("/posts/allbyblog")
    public List<PostDto> getAllByBlogId(@RequestParam int blogid) {
        return postService.getAllByBlogId(blogid);
    }

    @PostMapping("/posts/register")
    public void register(@RequestBody PostDto postDto) {
        postService.register(postDto);
    }
    
    @DeleteMapping("/posts/remove")
    public void remove(@RequestParam int id) {
        postService.remove(id);
    }
}
