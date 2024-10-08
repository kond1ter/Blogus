package com.konditer.blogus.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.dto.PostDto;
import com.konditer.blogus.entities.Post;
import com.konditer.blogus.repositories.PostRepository;
import com.konditer.blogus.services.contracts.PostServiceContract;

@Service
public class PostService implements PostServiceContract {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto get(int id) {
        // TODO: checks
        return mapPostntityToPostDto(postRepository.getReferenceById(id));
    }

    @Override
    public List<PostDto> getAllByBlogId(int id) {
        // TODO: implement
        return postRepository.findAll()
            .stream().map(p -> mapPostntityToPostDto(p))
            .collect(Collectors.toList());
    }

    @Override
    public void register(PostDto post) {
        // TODO: checks
        postRepository.save(mapPostDtoToPostEntity(post));
    }

    @Override
    public void remove(int id) {
        // TODO: implement marking as deleted
    }

    private PostDto mapPostntityToPostDto(Post post) {
        // TODO: implement mapping
        return new PostDto();
    }

    private Post mapPostDtoToPostEntity(PostDto postDto) {
        // TODO: implement mapping
        return new Post();
    }
}
