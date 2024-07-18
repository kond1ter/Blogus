package com.konditer.blogus.repositories.baseRepositories;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface DeleteRepository<T, ID> extends Repository<T, ID> {
    
    void delete(T entity);

    void deleteById(ID id);
}
