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

import com.konditer.blogus.dto.UserSubscribeDto;
import com.konditer.blogus.entities.UserSubscribe;
import com.konditer.blogus.services.BlogService;
import com.konditer.blogus.services.UserService;
import com.konditer.blogus.services.UserSubscribeService;

@RestController
public class UserSubscribeController {

    private UserSubscribeDto mapUserSubscribeEntityToUserSubscribeDto(UserSubscribe userSubscribe) {
        return new UserSubscribeDto(userSubscribe.getUser().getId(), 
            userSubscribe.getBlog().getId(),
            userSubscribe.getUser().getName(),
            userSubscribe.getBlog().getName());
    }

    private UserSubscribe mapUserSubscribeDtoToUserSubscribeEntity(UserSubscribeDto userSubscribeDto) {
        return new UserSubscribe(userService.getUserById(userSubscribeDto.getUserId()),
            blogService.getBlogById(userSubscribeDto.getBlogId()));
    }
    
    @Autowired
    private UserSubscribeService userSubscribeService;

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/userSubscribes/{id}")
    public UserSubscribeDto getUserSubscribeById(@PathVariable int id) {
        return mapUserSubscribeEntityToUserSubscribeDto(
            userSubscribeService.getUserSubscribeById(id));
    }

    @GetMapping("/userSubscribes")
    public List<UserSubscribeDto> getAllUserSubscribes() {
        return userSubscribeService.getAllUserSubscribes()
            .stream().map(us -> mapUserSubscribeEntityToUserSubscribeDto(us))
            .collect(Collectors.toList());
    }
    
    @PostMapping("/userSubscribes/register")
    public void registerUserSubscribe(@RequestBody UserSubscribeDto userSubscribeDto ) {
        userSubscribeService.registerUserSubscribe(
            mapUserSubscribeDtoToUserSubscribeEntity(userSubscribeDto));
    }

    @DeleteMapping("/userSubscribes/{id}")
    public void removeUserSubscribe(@PathVariable int id) {
        userSubscribeService.removeUserSubscribe(id);
    }
}
