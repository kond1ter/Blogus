package com.konditer.blogus.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.konditer.blogus.entities.Comment;
import com.konditer.blogus.repositories.baseRepositories.DeleteRepository;
import com.konditer.blogus.repositories.baseRepositories.FindRepository;
import com.konditer.blogus.repositories.baseRepositories.SaveRepository;


@Repository
public interface CommentRepository extends 
    DeleteRepository<Comment, Integer>,
    FindRepository<Comment, Integer>,
    SaveRepository<Comment, Integer> {
    
    List<Comment> findByPostId(int postId);
}
