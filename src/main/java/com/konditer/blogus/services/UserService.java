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

    private UserDto mapUserEntityToUserDto(User user) {
        return new UserDto(user.getName(), 
            user.getBirthDate(), user.getRegistrationDate(), user.getRating());
    }

    private User mapUserDtoToUserEntity(UserDto userDto) {
        return new User(userDto.name, userDto.birthDate);
    }

    @Override
    public UserDto getUserById(int id) {
        User user = userRepository.findById(id);
        return mapUserEntityToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(u -> mapUserEntityToUserDto(u))
            .collect(Collectors.toList());
    }

    @Override
    public void registerUser(UserDto userDto) {
        userRepository.save(mapUserDtoToUserEntity(userDto));
    }

    @Override
    public void removeUser(int id) {
        userRepository.delete(userRepository.findById(id));
    }
}
