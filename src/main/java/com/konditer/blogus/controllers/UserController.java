package com.konditer.blogus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.konditer.blogus.dto.UserDto;
import com.konditer.blogus.services.UserService;


@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable int id) {
        return (UserDto) userService.getUserById(id);
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return (List<UserDto>) userService.getAllUsers();
    }

    @PostMapping("/users/register")
    public void registerUser(@RequestBody UserDto userDto) {
        userService.registerUser(userDto);
    }

    @GetMapping("/users/{id}/remove")
    public void removeUser(@PathVariable int id) {
        userService.removeUser(id);
    }
}
