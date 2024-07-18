package com.konditer.blogus.services;

import java.sql.Timestamp;
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
    public UserDto getUserById(int id) {
        return mapUserEntityToUserDto(userRepository.findById(id).get());
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
            .stream().map(u -> mapUserEntityToUserDto(u))
            .collect(Collectors.toList());
    }

    @Override
    public void registerUser(UserDto user) {
        userRepository.save(mapUserDtoToUserEntity(user));
    }

    @Override
    public void removeUser(int id) {
        userRepository.delete(userRepository.findById(id).get());
    }

    @Override
    public void updateUserName(int id, String name) {
        User user = userRepository.findById(id).get();
        user.setName(name);
        user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        userRepository.save(user);
    }

    private UserDto mapUserEntityToUserDto(User user) {
        return new UserDto(user.getName(), user.getBirthDate(), user.getRating(),
            user.getCreatedAt(), user.getUpdatedAt());
    }

    private User mapUserDtoToUserEntity(UserDto userDto) {
        return new User(userDto.getName(), userDto.getBirthDate());
    }
}
