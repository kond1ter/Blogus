package com.konditer.blogus.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.konditer.blogus.dto.SubscribeDto;
import com.konditer.blogus.entities.Subscribe;
import com.konditer.blogus.services.BlogService;
import com.konditer.blogus.services.SubscribeService;
import com.konditer.blogus.services.UserService;

@RestController
public class SubscribeController {

    private SubscribeDto mapUserSubscribeEntityToUserSubscribeDto(Subscribe userSubscribe) {
        return new SubscribeDto(userSubscribe.getUser().getId(), 
            userSubscribe.getBlog().getId(),
            userSubscribe.getUser().getName(),
            userSubscribe.getBlog().getName());
    }

    private Subscribe mapUserSubscribeDtoToUserSubscribeEntity(SubscribeDto userSubscribeDto) {
        return new Subscribe(userService.getUserById(userSubscribeDto.getUserId()),
            blogService.getBlogById(userSubscribeDto.getBlogId()));
    }
    
    @Autowired
    private SubscribeService userSubscribeService;

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/userSubscribes/{id}")
    public SubscribeDto getUserSubscribeById(@PathVariable int id) {
        return mapUserSubscribeEntityToUserSubscribeDto(
            userSubscribeService.getUserSubscribeById(id));
    }

    @GetMapping("/userSubscribes")
    public List<SubscribeDto> getAllUserSubscribes() {
        return userSubscribeService.getAllUserSubscribes()
            .stream().map(us -> mapUserSubscribeEntityToUserSubscribeDto(us))
            .collect(Collectors.toList());
    }
    
    @PostMapping("/userSubscribes/register")
    public void registerUserSubscribe(@RequestBody SubscribeDto userSubscribeDto ) {
        userSubscribeService.registerUserSubscribe(
            mapUserSubscribeDtoToUserSubscribeEntity(userSubscribeDto));
    }

    @DeleteMapping("/userSubscribes/{id}")
    public void removeUserSubscribe(@PathVariable int id) {
        userSubscribeService.removeUserSubscribe(id);
    }
}
