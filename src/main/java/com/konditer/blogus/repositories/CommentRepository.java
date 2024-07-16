package com.konditer.blogus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.konditer.blogus.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    
}
