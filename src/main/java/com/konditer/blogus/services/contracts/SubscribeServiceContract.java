package com.konditer.blogus.services.contracts;

import java.util.List;

import com.konditer.blogus.entities.Subscribe;

public interface SubscribeServiceContract {
    
    Subscribe getUserSubscribeById(int id);

    List<Subscribe> getAllUserSubscribes();

    void registerUserSubscribe(Subscribe userSubscribe);

    void removeUserSubscribe(int id);
}
