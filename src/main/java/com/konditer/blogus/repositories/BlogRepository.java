package com.konditer.blogus.repositories;


import org.springframework.stereotype.Repository;

import com.konditer.blogus.entities.Blog;
import com.konditer.blogus.repositories.baseRepositories.DeleteRepository;
import com.konditer.blogus.repositories.baseRepositories.FindRepository;
import com.konditer.blogus.repositories.baseRepositories.SaveRepository;

@Repository
public interface BlogRepository extends 
    FindRepository<Blog, Integer>,
    SaveRepository<Blog, Integer>,
    DeleteRepository<Blog, Integer> {

}
