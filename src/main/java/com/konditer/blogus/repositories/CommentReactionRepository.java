package com.konditer.blogus.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.konditer.blogus.entities.CommentReaction;
import com.konditer.blogus.repositories.baseRepositories.DeleteRepository;
import com.konditer.blogus.repositories.baseRepositories.FindRepository;
import com.konditer.blogus.repositories.baseRepositories.SaveRepository;

@Repository
public interface CommentReactionRepository extends 
    DeleteRepository<CommentReaction, Integer>,
    FindRepository<CommentReaction, Integer>,
    SaveRepository<CommentReaction, Integer> {
    
    List<CommentReaction> findByCommentIdAndPositive(int commentId, boolean positive);
}
