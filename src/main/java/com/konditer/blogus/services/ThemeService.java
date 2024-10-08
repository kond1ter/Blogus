package com.konditer.blogus.services;

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
    public List<ThemeDto> getAll() {
        // TODO: implement
        return themeRepository.findAll()
            .stream().map(t -> mapThemeEntityToThemeDto(t))
            .collect(Collectors.toList());
    }

    @Override
    public void register(ThemeDto theme) {
        // TODO: checks
        themeRepository.save(mapThemeDtoToThemeEntity(theme));
    }

    @Override
    public void remove(int id) {
        // TODO: implement marking as deleted
    }
    
    private ThemeDto mapThemeEntityToThemeDto(Theme theme) {
        // TODO: implement mapping
        return new ThemeDto();
    }

    private Theme mapThemeDtoToThemeEntity(ThemeDto themeDto) {
        // TODO: implement mapping
        return new Theme();
    }
}
