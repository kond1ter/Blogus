package com.konditer.blogus.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.konditer.blogus.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    
    List<Comment> findByPostId(int id);
}
