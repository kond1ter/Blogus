package com.konditer.blogus.services.contracts;

import java.util.List;

import com.konditer.blogus.dto.SubscribeDto;

public interface SubscribeServiceContract {
    
    SubscribeDto getUserSubscribeById(int id);

    List<SubscribeDto> getAllUserSubscribes();

    void registerUserSubscribe(SubscribeDto userSubscribe);

    void removeUserSubscribe(int id);
}
