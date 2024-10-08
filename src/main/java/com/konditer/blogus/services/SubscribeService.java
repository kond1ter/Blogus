package com.konditer.blogus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.dto.SubscribeDto;
import com.konditer.blogus.entities.Subscribe;
import com.konditer.blogus.repositories.SubscribeRepository;
import com.konditer.blogus.services.contracts.SubscribeServiceContract;

@Service
public class SubscribeService implements SubscribeServiceContract{

    @Autowired
    private SubscribeRepository userSubscribeRepository;

    @Override
    public void register(SubscribeDto userSubscribe) {
        // TODO: checks
        userSubscribeRepository.save(mapToEntity(userSubscribe));
    }

    @Override
    public void remove(int id) {
        // TODO: implement marking as deleted
    }

    private Subscribe mapToEntity(SubscribeDto userSubscribeDto) {
        // TODO: implement mapping
        return new Subscribe();
    }
}
