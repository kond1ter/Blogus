package com.konditer.blogus.services.contracts;

import java.util.List;

import com.konditer.blogus.dto.UserDto;

public interface UserServiceContract {

    UserDto getUserById(int id);

    List<UserDto> getAllUsers();

    void registerUser(UserDto userDto);

    void removeUser(int id);
}
