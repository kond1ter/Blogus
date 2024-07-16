package com.konditer.blogus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.konditer.blogus.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    User findById(int id);
}
