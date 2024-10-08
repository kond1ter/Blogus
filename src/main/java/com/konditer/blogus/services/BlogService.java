package com.konditer.blogus.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.dto.BlogDto;
import com.konditer.blogus.entities.Blog;
import com.konditer.blogus.repositories.BlogRepository;
import com.konditer.blogus.services.contracts.BlogServiceContract;

@Service
public class BlogService implements BlogServiceContract {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public BlogDto get(int id) {
        // TODO: checks
        return mapToDto(blogRepository.getReferenceById(id));
    }

    @Override
    public List<BlogDto> getFeatured() {
        // TODO: implement featured
        return blogRepository.findAll().stream()
            .map(b -> mapToDto(b))
            .collect(Collectors.toList());
    }

    @Override
    public List<BlogDto> getRecommendedByUserId(int id) {
        // TODO: implenemt recommended
        return blogRepository.findAll().stream()
            .map(b -> mapToDto(b))
            .collect(Collectors.toList());
    }

    @Override
    public List<BlogDto> getAllByUserId(int id) {
        // TODO: implenemt recommended
        return blogRepository.findAll().stream()
            .map(b -> mapToDto(b))
            .collect(Collectors.toList());
    }

    @Override
    public void register(BlogDto blog) {
        // TODO: checks
        blogRepository.save(mapToEntity(blog));
    }

    @Override
    public void remove(int id) {
        // TODO: checks
        // TODO: implement marking as deleted
    }

    private BlogDto mapToDto(Blog blog) {
        // TODO: implement mapper
        return new BlogDto();
    }

    private Blog mapToEntity(BlogDto blogDto) {
        // TODO: implement mapper
        return new Blog();
    }
}
