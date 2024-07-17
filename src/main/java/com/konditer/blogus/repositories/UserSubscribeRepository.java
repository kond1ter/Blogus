package com.konditer.blogus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.konditer.blogus.entities.UserSubscribe;

@Repository
public interface UserSubscribeRepository extends JpaRepository<UserSubscribe, Integer> {
    
    UserSubscribe findById(int id);
}
