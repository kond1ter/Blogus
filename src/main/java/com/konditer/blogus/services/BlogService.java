package com.konditer.blogus.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.entities.Blog;
import com.konditer.blogus.entities.Theme;
import com.konditer.blogus.repositories.BlogRepository;
import com.konditer.blogus.services.contracts.BlogServiceContract;

@Service
public class BlogService implements BlogServiceContract {
    
    @Autowired
    public BlogRepository blogRepository;

    @Override
    public Blog getBlogById(int id) {
        Blog blog = blogRepository.findById(id);
        return blog;
    }

    @Override
    public List<Blog> getAllBlogs() {
        List<Blog> blogs = blogRepository.findAll();
        return blogs;
    }

    @Override
    public void registerBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void removeBlog(int id) {
        blogRepository.delete(blogRepository.findById(id));
    }

    @Override
    public void updateBlogName(int id, String name) {
        Blog blog = blogRepository.findById(id);
        blog.setName(name);
        blog.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        blogRepository.save(blog);
    }

    @Override
    public void updateBlogClosed(int id, boolean closed) {
        Blog blog = blogRepository.findById(id);
        blog.setClosed(closed);
        blog.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        blogRepository.save(blog);
    }

    @Override
    public void updateBlogTheme(int id, Theme theme) {
        Blog blog = blogRepository.findById(id);
        blog.setTheme(theme);
        blog.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        blogRepository.save(blog);
    }
}
