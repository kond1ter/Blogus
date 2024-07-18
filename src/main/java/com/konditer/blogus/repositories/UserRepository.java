package com.konditer.blogus.repositories;

import org.springframework.stereotype.Repository;

import com.konditer.blogus.entities.User;
import com.konditer.blogus.repositories.baseRepositories.DeleteRepository;
import com.konditer.blogus.repositories.baseRepositories.FindRepository;
import com.konditer.blogus.repositories.baseRepositories.SaveRepository;

@Repository
public interface UserRepository extends
    DeleteRepository<User, Integer>,
    FindRepository<User, Integer>,
    SaveRepository<User, Integer> {
    
}
