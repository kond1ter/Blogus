package com.konditer.blogus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.konditer.blogus.entities.BlogNote;

public interface BlogNoteRepository extends JpaRepository<BlogNote, Integer> {
    
}
