package com.konditer.blogus.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.entities.Theme;
import com.konditer.blogus.repositories.ThemeRepository;
import com.konditer.blogus.services.contracts.ThemeServiceContract;

@Service
public class ThemeService implements ThemeServiceContract {
    
    @Autowired
    private ThemeRepository themeRepository;

    @Override
    public Theme getThemeById(int id) {
        return themeRepository.findThemeById(id);
    }

    @Override
    public List<Theme> getAllThemes() {
        return themeRepository.findAll();
    }

    @Override
    public void updateThemeName(int id, String name) {
        Theme theme = themeRepository.findThemeById(id);
        theme.setName(name);
        theme.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public void registerTheme(Theme theme) {
        themeRepository.save(theme);
    }

    @Override
    public void removeTheme(int id) {
        themeRepository.delete(themeRepository.findThemeById(id));
    }
}
