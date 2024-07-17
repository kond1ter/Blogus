package com.konditer.blogus.services.contracts;

import java.util.List;

import com.konditer.blogus.entities.Blog;
import com.konditer.blogus.entities.Theme;

public interface BlogServiceContract {

    Blog getBlogById(int id);
    
    List<Blog> getAllBlogs();

    void registerBlog(Blog blog);

    void removeBlog(int id);

    void updateBlogName(int id, String name);

    void updateBlogClosed(int id, boolean closed);

    void updateBlogTheme(int id, Theme theme);
}
