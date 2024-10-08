package com.konditer.blogus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.konditer.blogus.dto.UserDto;
import com.konditer.blogus.services.UserService;


@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/users/one")
    public UserDto get(@RequestParam int id) {
        return userService.get(id);
    }

    @GetMapping("/users/allbyblog")
    public List<UserDto> getAllByBlogId(@RequestParam int blogid) {
        return userService.getAllByBlogId(blogid);
    }

    @PostMapping("/users/register")
    public void register(@RequestBody UserDto userDto) {
        userService.register(userDto);
    }

    @DeleteMapping("/users/remove")
    public void remove(@RequestParam int id) {
        userService.remove(id);
    }
}
