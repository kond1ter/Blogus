package com.konditer.blogus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.konditer.blogus.entities.UserSubscribe;

public interface UserSubscribeRepository extends JpaRepository<UserSubscribe, Integer> {
    
}
