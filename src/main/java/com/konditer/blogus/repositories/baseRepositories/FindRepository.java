package com.konditer.blogus.repositories.baseRepositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface FindRepository<T, ID> extends Repository<T, ID>{
    
    Optional<T> findById(ID id);

    List<T> findAll();
}
