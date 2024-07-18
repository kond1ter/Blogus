package com.konditer.blogus.repositories;

import org.springframework.stereotype.Repository;

import com.konditer.blogus.entities.Theme;
import com.konditer.blogus.repositories.baseRepositories.DeleteRepository;
import com.konditer.blogus.repositories.baseRepositories.FindRepository;
import com.konditer.blogus.repositories.baseRepositories.SaveRepository;

@Repository
public interface ThemeRepository extends
    DeleteRepository<Theme, Integer>,
    FindRepository<Theme, Integer>,
    SaveRepository<Theme, Integer> {

}
