package com.konditer.blogus.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.dto.UserDto;
import com.konditer.blogus.entities.User;
import com.konditer.blogus.repositories.UserRepository;
import com.konditer.blogus.services.contracts.UserServiceContract;

@Service
public class UserService implements UserServiceContract {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto get(int id) {
        // TODO: checks
        return mapToDto(userRepository.findById(id).get());
    }

    @Override
    public List<UserDto> getAllByBlogId(int id) {
        // TODO: implement and checks
        return userRepository.findAll()
            .stream().map(u -> mapToDto(u))
            .collect(Collectors.toList());
    }

    @Override
    public void register(UserDto user) {
        // TODO: checks
        userRepository.save(mapToEntity(user));
    }

    @Override
    public void remove(int id) {
        // TODO: implement marking as deleted
    }

    private UserDto mapToDto(User user) {
        // TODO: implement mapping
        return new UserDto();
    }

    private User mapToEntity(UserDto userDto) {
        // TODO: implement mapping
        return new User();
    }
}
