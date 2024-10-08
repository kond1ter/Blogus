package com.konditer.blogus.services.contracts;

import java.util.List;

import com.konditer.blogus.dto.BlogDto;

public interface BlogServiceContract {

    BlogDto get(int id);
    
    List<BlogDto> getFeatured();

    List<BlogDto> getRecommendedByUserId(int id);

    List<BlogDto> getAllByUserId(int id);

    void register(BlogDto blog);

    void remove(int id);
}
