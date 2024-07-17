package com.konditer.blogus.services.contracts;

import java.util.List;

import com.konditer.blogus.entities.User;

public interface UserServiceContract {

    User getUserById(int id);

    List<User> getAllUsers();

    void registerUser(User user);

    void removeUser(int id);

    void updateUserName(int id, String name);
}
