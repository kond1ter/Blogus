package com.konditer.blogus.services.contracts;

import com.konditer.blogus.dto.SubscribeDto;

public interface SubscribeServiceContract {

    void register(SubscribeDto subscribe);

    void remove(int id);
}
