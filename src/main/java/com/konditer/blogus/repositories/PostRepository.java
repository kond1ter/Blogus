package com.konditer.blogus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.konditer.blogus.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    
    Post findById(int id);
}
