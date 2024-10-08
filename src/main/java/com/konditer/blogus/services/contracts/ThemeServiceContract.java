package com.konditer.blogus.services.contracts;

import java.util.List;

import com.konditer.blogus.dto.ThemeDto;

public interface ThemeServiceContract {
    
    List<ThemeDto> getAll();

    void register(ThemeDto theme);

    void remove(int id);
}
