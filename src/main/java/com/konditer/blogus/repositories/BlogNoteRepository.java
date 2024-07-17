package com.konditer.blogus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.konditer.blogus.entities.BlogNote;

@Repository
public interface BlogNoteRepository extends JpaRepository<BlogNote, Integer> {
    
    BlogNote findById(int id);
}
