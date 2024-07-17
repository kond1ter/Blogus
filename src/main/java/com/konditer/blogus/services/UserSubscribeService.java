package com.konditer.blogus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.entities.UserSubscribe;
import com.konditer.blogus.repositories.UserSubscribeRepository;
import com.konditer.blogus.services.contracts.UserSubscribeServiceContract;

@Service
public class UserSubscribeService implements UserSubscribeServiceContract{

    @Autowired
    private UserSubscribeRepository userSubscribeRepository;

    @Override
    public UserSubscribe getUserSubscribeById(int id) {
        return userSubscribeRepository.findById(id);
    }

    @Override
    public List<UserSubscribe> getAllUserSubscribes() {
        return userSubscribeRepository.findAll();
    }

    @Override
    public void registerUserSubscribe(UserSubscribe userSubscribe) {
        userSubscribeRepository.save(userSubscribe);
    }

    @Override
    public void removeUserSubscribe(int id) {
        userSubscribeRepository.delete(userSubscribeRepository.findById(id));
    }
}
