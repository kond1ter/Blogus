package com.konditer.blogus.services.contracts;

import java.util.List;

import com.konditer.blogus.dto.BlogDto;

public interface BlogServiceContract {

    BlogDto getBlogById(int id);
    
    List<BlogDto> getAllBlogs();

    List<BlogDto> getRecomendedBlogs(int userId);

    void registerBlog(BlogDto blog);

    void removeBlog(int id);

    void updateBlogName(int id, String name);

    void updateBlogClosed(int id, boolean closed);

    void updateBlogTheme(int id, int themeId);
}
