package com.konditer.blogus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.konditer.blogus.entities.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer>{

    Blog findById(int id);
}
