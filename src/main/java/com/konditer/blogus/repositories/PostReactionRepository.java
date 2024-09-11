package com.konditer.blogus.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.konditer.blogus.entities.PostReaction;

@Repository
public interface PostReactionRepository extends JpaRepository<PostReaction, Integer> {
    
    Optional<PostReaction> findByAuthorId(int id);

    List<PostReaction> findByPostIdAndPositive(int postId, boolean positive);
}
