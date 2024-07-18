package com.konditer.blogus.repositories;

import org.springframework.stereotype.Repository;

import com.konditer.blogus.entities.Subscribe;
import com.konditer.blogus.repositories.baseRepositories.DeleteRepository;
import com.konditer.blogus.repositories.baseRepositories.FindRepository;
import com.konditer.blogus.repositories.baseRepositories.SaveRepository;

@Repository
public interface SubscribeRepository extends
    DeleteRepository<Subscribe, Integer>,
    FindRepository<Subscribe, Integer>,
    SaveRepository<Subscribe, Integer> {
    
}
