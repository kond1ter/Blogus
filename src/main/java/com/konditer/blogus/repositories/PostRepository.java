package com.konditer.blogus.repositories;

import org.springframework.stereotype.Repository;

import com.konditer.blogus.entities.Post;
import com.konditer.blogus.repositories.baseRepositories.DeleteRepository;
import com.konditer.blogus.repositories.baseRepositories.FindRepository;
import com.konditer.blogus.repositories.baseRepositories.SaveRepository;

@Repository
public interface PostRepository extends
    DeleteRepository<Post, Integer>,
    FindRepository<Post, Integer>,
    SaveRepository<Post, Integer> {
    
}
