package com.konditer.blogus.services;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.entities.Blog;
import com.konditer.blogus.entities.Subscribe;
import com.konditer.blogus.entities.Theme;
import com.konditer.blogus.repositories.BlogRepository;
import com.konditer.blogus.repositories.UserRepository;
import com.konditer.blogus.services.contracts.BlogServiceContract;

@Service
public class BlogService implements BlogServiceContract {

    private final double USER_BAN_RATING = -2.0;
    private final double BLOG_BAN_RATING = -5.0;
    private final int MAX_BLOG_PUBLISH_GAP = 30 * 24 * 60 * 60 * 1000;
    
    @Autowired
    public BlogRepository blogRepository;

    @Autowired
    public UserRepository userRepository;

    @Override
    public Blog getBlogById(int id) {
        Blog blog = blogRepository.findById(id).get();
        return blog;
    }

    @Override
    public List<Blog> getAllBlogs() {
        long timestamp = new Timestamp(System.currentTimeMillis()).getTime();
        
        List<Blog> blogs = blogRepository.findAll();
        List<Blog> filteredBlogs = blogs.stream()
            .filter(blog -> !blog.isClosed())
            .filter(blog -> blog.getRating() > BLOG_BAN_RATING)
            .filter(blog -> blog.getAuthor().getRating() > USER_BAN_RATING)
            .filter(blog -> blog.getUpdatedAt().getTime() > timestamp - MAX_BLOG_PUBLISH_GAP)
            .collect(Collectors.toList());

        Collections.sort(filteredBlogs, (b1, b2) -> Double.compare(
            b2.getRating()/b2.getPosts().size(), b1.getRating()/b1.getPosts().size()));
        return filteredBlogs;
    }

    @Override
    public List<Blog> getRecomendedBlogs(int userId) {
        List<Blog> blogs = this.getAllBlogs();
        List<Theme> themes = userRepository.findById(userId)
            .get().getSubscribes().stream()
            .map(Subscribe::getBlog).map(Blog::getTheme)
            .collect(Collectors.toList());
        List<Blog> recommendedBlogs = blogs.stream()
            .filter(blog -> themes.contains(blog.getTheme()))
            .collect(Collectors.toList());
        return recommendedBlogs;
    }

    @Override
    public void registerBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void removeBlog(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void updateBlogName(int id, String name) {
        Blog blog = blogRepository.findById(id).get();
        blog.setName(name);
        blog.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        blogRepository.save(blog);
    }

    @Override
    public void updateBlogClosed(int id, boolean closed) {
        Blog blog = blogRepository.findById(id).get();
        blog.setClosed(closed);
        blog.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        blogRepository.save(blog);
    }

    @Override
    public void updateBlogTheme(int id, Theme theme) {
        Blog blog = blogRepository.findById(id).get();
        blog.setTheme(theme);
        blog.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        blogRepository.save(blog);
    }
}
