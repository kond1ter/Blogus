package com.konditer.blogus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.konditer.blogus.dto.SubscribeDto;
import com.konditer.blogus.services.SubscribeService;

@RestController
public class SubscribeController {
    
    @Autowired
    private SubscribeService userSubscribeService;

    @PostMapping("/subscribes/register")
    public void register(@RequestBody SubscribeDto userSubscribeDto ) {
        userSubscribeService.register(userSubscribeDto);
    }

    @DeleteMapping("/subscribes/remove")
    public void remove(@RequestParam int id) {
        userSubscribeService.remove(id);
    }
}
