package com.konditer.blogus.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.dto.ThemeDto;
import com.konditer.blogus.entities.Theme;
import com.konditer.blogus.repositories.ThemeRepository;
import com.konditer.blogus.services.contracts.ThemeServiceContract;

@Service
public class ThemeService implements ThemeServiceContract {
    
    @Autowired
    private ThemeRepository themeRepository;

    @Override
    public ThemeDto getThemeById(int id) {
        return mapThemeEntityToThemeDto(themeRepository.findById(id).get());
    }

    @Override
    public List<ThemeDto> getAllThemes() {
        return themeRepository.findAll()
            .stream().map(t -> mapThemeEntityToThemeDto(t))
            .collect(Collectors.toList());
    }

    @Override
    public void updateThemeName(int id, String name) {
        Theme theme = themeRepository.findById(id).get();
        theme.setName(name);
        theme.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        themeRepository.save(theme);
    }

    @Override
    public void registerTheme(ThemeDto theme) {
        themeRepository.save(mapThemeDtoToThemeEntity(theme));
    }

    @Override
    public void removeTheme(int id) {
        themeRepository.deleteById(id);
    }
    
    private ThemeDto mapThemeEntityToThemeDto(Theme theme) {
        return new ThemeDto(theme.getName(),
            theme.getCreatedAt(), theme.getUpdatedAt());
    }

    private Theme mapThemeDtoToThemeEntity(ThemeDto themeDto) {
        return new Theme(themeDto.getName());
    }
}
