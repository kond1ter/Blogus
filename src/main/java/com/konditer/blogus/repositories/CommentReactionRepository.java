package com.konditer.blogus.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.konditer.blogus.entities.CommentReaction;

@Repository
public interface CommentReactionRepository extends JpaRepository<CommentReaction, Integer> {
    
    List<CommentReaction> findByCommentIdAndPositive(int commentId, boolean positive);
}
