package com.konditer.blogus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.konditer.blogus.entities.Theme;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Integer> {

    Theme findThemeById(int id);
}
