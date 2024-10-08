package com.konditer.blogus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.konditer.blogus.entities.PostReaction;

@Repository
public interface PostReactionRepository extends JpaRepository<PostReaction, Integer> {
    
}
