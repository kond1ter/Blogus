package com.konditer.blogus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.konditer.blogus.dto.SubscribeDto;
import com.konditer.blogus.services.SubscribeService;

@RestController
public class SubscribeController {
    
    @Autowired
    private SubscribeService userSubscribeService;

    @GetMapping("/userSubscribes/{id}")
    public SubscribeDto getUserSubscribeById(@PathVariable int id) {
        return userSubscribeService.getUserSubscribeById(id);
    }

    @GetMapping("/userSubscribes")
    public List<SubscribeDto> getAllUserSubscribes() {
        return userSubscribeService.getAllUserSubscribes();
    }
    
    @PostMapping("/userSubscribes/register")
    public void registerUserSubscribe(@RequestBody SubscribeDto userSubscribeDto ) {
        userSubscribeService.registerUserSubscribe(userSubscribeDto);
    }

    @DeleteMapping("/userSubscribes/{id}")
    public void removeUserSubscribe(@PathVariable int id) {
        userSubscribeService.removeUserSubscribe(id);
    }
}
