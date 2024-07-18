package com.konditer.blogus.repositories.baseRepositories;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface SaveRepository<T, ID> extends Repository<T, ID>{
    
    void save(T entity);
}
