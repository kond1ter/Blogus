package com.konditer.blogus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.konditer.blogus.entities.Subscribe;

@Repository
public interface SubscribeRepository extends JpaRepository<Subscribe, Integer> {
    
    Subscribe findById(int id);
}
