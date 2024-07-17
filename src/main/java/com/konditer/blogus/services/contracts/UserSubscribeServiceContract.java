package com.konditer.blogus.services.contracts;

import java.util.List;

import com.konditer.blogus.entities.UserSubscribe;

public interface UserSubscribeServiceContract {
    
    UserSubscribe getUserSubscribeById(int id);

    List<UserSubscribe> getAllUserSubscribes();

    void registerUserSubscribe(UserSubscribe userSubscribe);

    void removeUserSubscribe(int id);
}
