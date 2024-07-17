package com.konditer.blogus.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.konditer.blogus.dto.ThemeDto;
import com.konditer.blogus.entities.Theme;
import com.konditer.blogus.services.ThemeService;

@RestController
public class ThemeController {
    
    private ThemeDto mapThemeEntityToThemeDto(Theme theme) {
        return new ThemeDto(theme.getName());
    }

    private Theme mapThemeDtoToThemeEntity(ThemeDto themeDto) {
        return new Theme(themeDto.getName());
    }

    @Autowired
    private ThemeService themeService;

    @GetMapping("/themes/{id}")
    public ThemeDto getThemeById(@PathVariable int id) {
        Theme theme = themeService.getThemeById(id);
        return mapThemeEntityToThemeDto(theme);
    }

    @GetMapping("/themes")
    public List<ThemeDto> getAllThemes() {
        List<Theme> themes = themeService.getAllThemes();
        return themes.stream().map(t -> mapThemeEntityToThemeDto(t))
            .collect(Collectors.toList());
    }
    
    @PostMapping("/themes/register")
    public void registerTheme(@RequestBody ThemeDto themeDto) {
        themeService.registerTheme(mapThemeDtoToThemeEntity(themeDto));
    }
    
    @DeleteMapping("/themes/{id}")
    public void removeTheme(@PathVariable int id) {
        themeService.removeTheme(id);
    }

    @GetMapping("themes/{id}/rename")
    public void updateThemeName(@PathVariable int id, @RequestParam String name) {
        themeService.updateThemeName(id, name);
    }
}
