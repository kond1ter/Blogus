package com.konditer.blogus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.konditer.blogus.dto.BlogDto;
import com.konditer.blogus.services.BlogService;

@RestController
public class BlogController {
    
    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs/one")
    public BlogDto get(@RequestParam int id) {
        return blogService.get(id);
    }

    @GetMapping("/blogs/featured")
    public List<BlogDto> getFeatured() {
        return blogService.getFeatured();
    }

    @GetMapping("/blogs/recommended")
    public List<BlogDto> getRecommended(@RequestParam int userid) {
        return blogService.getRecommendedByUserId(userid);
    }

    @GetMapping("/blogs/allbyuser")
    public List<BlogDto> getUserBlogs(@RequestParam int userid) {
        return blogService.getAllByUserId(userid);
    }

    @PostMapping("/blogs/register")
    public void register(@RequestBody BlogDto blogDto) {
        blogService.register(blogDto);
    }

    @DeleteMapping("/blogs/remove")
    public void remove(@RequestParam int id) {
        blogService.remove(id);
    }
}
