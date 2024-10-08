package com.konditer.blogus.services.contracts;

import java.util.List;

import com.konditer.blogus.dto.UserDto;

public interface UserServiceContract {

    UserDto get(int id);

    List<UserDto> getAllByBlogId(int id);

    void register(UserDto user);

    void remove(int id);
}
