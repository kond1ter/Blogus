package com.konditer.blogus.services.contracts;

import java.util.List;

import com.konditer.blogus.entities.Theme;

public interface ThemeServiceContract {
    
    Theme getThemeById(int id);

    List<Theme> getAllThemes();

    void registerTheme(Theme theme);

    void removeTheme(int id);

    void updateThemeName(int id, String name);
}
