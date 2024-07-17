package com.konditer.blogus.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.konditer.blogus.dto.UserDto;
import com.konditer.blogus.entities.User;
import com.konditer.blogus.services.UserService;


@RestController
public class UserController {

    private UserDto mapUserEntityToUserDto(User user) {
        return new UserDto(user.getName(), user.getBirthDate(), user.getRating());
    }

    private User mapUserDtoToUserEntity(UserDto userDto) {
        return new User(userDto.getName(), userDto.getBirthDate());
    }
    
    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        return mapUserEntityToUserDto(user);
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users.stream().map(u -> mapUserEntityToUserDto(u))
            .collect(Collectors.toList());
    }

    @PostMapping("/users/register")
    public void registerUser(@RequestBody UserDto userDto) {
        userService.registerUser(mapUserDtoToUserEntity(userDto));
    }

    @DeleteMapping("/users/{id}")
    public void removeUser(@PathVariable int id) {
        userService.removeUser(id);
    }

    @GetMapping("/users/{id}/rename")
    public void updateUserName(@RequestParam String name, @PathVariable int id) {
        userService.updateUserName(id, name);
    }
}
