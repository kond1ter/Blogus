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

import com.konditer.blogus.dto.BlogDto;
import com.konditer.blogus.services.BlogService;

@RestController
public class BlogController {
    
    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs/{id}")
    public BlogDto getBlogById(@PathVariable int id) {
        BlogDto blog = blogService.getBlogById(id);
        return blog;
    }

    @GetMapping("/blogs")
    public List<BlogDto> getAllBlogs() {
        List<BlogDto> blogs = blogService.getAllBlogs();
        return blogs;
    }

    @GetMapping("/blogs/recomended")
    public List<BlogDto> getRecomendedBlogs(@RequestParam int userId) {
        List<BlogDto> blogs = blogService.getRecomendedBlogs(userId);
        return blogs;
    }

    @PostMapping("/blogs/register")
    public void registerBlog(@RequestBody BlogDto blogDto) {
        blogService.registerBlog(blogDto);
    }

    @DeleteMapping("/blogs/{id}")
    public void removeBlog(@PathVariable int id) {
        blogService.removeBlog(id);
    }
    
    @GetMapping("/blogs/{id}/rename")
    public void updateUserName(@RequestParam String name, @PathVariable int id) {
        blogService.updateBlogName(id, name);
    }
    
    @GetMapping("/blogs{id}/updateClosed")
    public void updateBlogClosed(@RequestParam boolean closed, @PathVariable int id) {
        blogService.updateBlogClosed(id, closed);
    }
    
    @GetMapping("/blogs/{id}/updateTheme")
    public void updateBlogTheme(@RequestParam int themeId, @PathVariable int id) {
        blogService.updateBlogTheme(id, themeId);
    }
}
