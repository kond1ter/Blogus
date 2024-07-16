package com.konditer.blogus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.konditer.blogus.entities.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Integer> {
    
}
