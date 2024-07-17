package com.konditer.blogus.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.konditer.blogus.dto.BlogDto;
import com.konditer.blogus.entities.Blog;
import com.konditer.blogus.services.BlogService;
import com.konditer.blogus.services.ThemeService;
import com.konditer.blogus.services.UserService;

@RestController
public class BlogController {
    
    private BlogDto mapBlogEntityToBlogDto(Blog blog) {
        return new BlogDto(blog.getName(), blog.isClosed(), blog.getRating(),
            blog.getAuthor().getId(), blog.getTheme().getId(), 
            blog.getPosts().size(), blog.getSubscribes().size(),
            blog.getCreatedAt(), blog.getUpdatedAt());
    }

    private Blog mapBlogDtoToBlogEntity(BlogDto blogDto) {
        return new Blog(blogDto.getName(), 
            userService.getUserById(blogDto.getAuthorId()),
            themeService.getThemeById(blogDto.getThemeId()),
            blogDto.isClosed());
    }

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @Autowired
    private ThemeService themeService;

    @GetMapping("/blogs/{id}")
    public BlogDto getBlogById(@PathVariable int id) {
        Blog blog = blogService.getBlogById(id);
        return mapBlogEntityToBlogDto(blog);
    }

    @GetMapping("/blogs")
    public List<BlogDto> getAllBlogs() {
        List<Blog> blogs = blogService.getAllBlogs();
        return blogs.stream().map(b -> mapBlogEntityToBlogDto(b))
            .collect(Collectors.toList());
    }

    @PostMapping("/blogs/register")
    public void registerBlog(@RequestBody BlogDto blogDto) {
        blogService.registerBlog(mapBlogDtoToBlogEntity(blogDto));
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
        blogService.updateBlogTheme(id, themeService.getThemeById(themeId));
    }
}
