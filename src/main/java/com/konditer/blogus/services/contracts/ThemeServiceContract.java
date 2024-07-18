package com.konditer.blogus.services.contracts;

import java.util.List;

import com.konditer.blogus.dto.ThemeDto;

public interface ThemeServiceContract {
    
    ThemeDto getThemeById(int id);

    List<ThemeDto> getAllThemes();

    void registerTheme(ThemeDto theme);

    void removeTheme(int id);

    void updateThemeName(int id, String name);
}
