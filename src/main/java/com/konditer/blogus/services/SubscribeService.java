package com.konditer.blogus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.entities.Subscribe;
import com.konditer.blogus.repositories.SubscribeRepository;
import com.konditer.blogus.services.contracts.SubscribeServiceContract;

@Service
public class SubscribeService implements SubscribeServiceContract{

    @Autowired
    private SubscribeRepository userSubscribeRepository;

    @Override
    public Subscribe getUserSubscribeById(int id) {
        return userSubscribeRepository.findById(id);
    }

    @Override
    public List<Subscribe> getAllUserSubscribes() {
        return userSubscribeRepository.findAll();
    }

    @Override
    public void registerUserSubscribe(Subscribe userSubscribe) {
        userSubscribeRepository.save(userSubscribe);
    }

    @Override
    public void removeUserSubscribe(int id) {
        userSubscribeRepository.delete(userSubscribeRepository.findById(id));
    }
}
