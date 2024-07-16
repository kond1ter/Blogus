package com.konditer.blogus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.konditer.blogus.entities.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer>{
    
}
