package com.konditer.blogus.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.konditer.blogus.entities.PostReaction;
import com.konditer.blogus.repositories.baseRepositories.DeleteRepository;
import com.konditer.blogus.repositories.baseRepositories.FindRepository;
import com.konditer.blogus.repositories.baseRepositories.SaveRepository;

@Repository
public interface PostReactionRepository extends
    DeleteRepository<PostReaction, Integer>,
    FindRepository<PostReaction, Integer>,
    SaveRepository<PostReaction, Integer> {
    
    List<PostReaction> findByPostIdAndPositive(int id, boolean positive);

    Optional<PostReaction> findByAuthorId(int id);
}
