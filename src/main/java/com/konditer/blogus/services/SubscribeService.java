package com.konditer.blogus.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.dto.SubscribeDto;
import com.konditer.blogus.entities.Subscribe;
import com.konditer.blogus.repositories.BlogRepository;
import com.konditer.blogus.repositories.SubscribeRepository;
import com.konditer.blogus.repositories.UserRepository;
import com.konditer.blogus.services.contracts.SubscribeServiceContract;

@Service
public class SubscribeService implements SubscribeServiceContract{

    @Autowired
    private SubscribeRepository userSubscribeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public SubscribeDto getUserSubscribeById(int id) {
        return mapUserSubscribeEntityToUserSubscribeDto(userSubscribeRepository.findById(id).get());
    }

    @Override
    public List<SubscribeDto> getAllUserSubscribes() {
        return userSubscribeRepository.findAll().stream()
            .map(s -> mapUserSubscribeEntityToUserSubscribeDto(s))
            .collect(Collectors.toList());
    }

    @Override
    public void registerUserSubscribe(SubscribeDto userSubscribe) {
        userSubscribeRepository.save(mapUserSubscribeDtoToUserSubscribeEntity(userSubscribe));
    }

    @Override
    public void removeUserSubscribe(int id) {
        userSubscribeRepository.deleteById(id);
    }

    private SubscribeDto mapUserSubscribeEntityToUserSubscribeDto(Subscribe userSubscribe) {
        return new SubscribeDto(userSubscribe.getUser().getId(), 
            userSubscribe.getBlog().getId(),
            userSubscribe.getUser().getName(),
            userSubscribe.getBlog().getName());
    }

    private Subscribe mapUserSubscribeDtoToUserSubscribeEntity(SubscribeDto userSubscribeDto) {
        return new Subscribe(userRepository.findById(userSubscribeDto.getUserId()).get(),
            blogRepository.findById(userSubscribeDto.getBlogId()).get());
    }
}
