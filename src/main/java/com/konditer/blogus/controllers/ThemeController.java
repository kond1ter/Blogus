package com.konditer.blogus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.konditer.blogus.dto.ThemeDto;
import com.konditer.blogus.services.ThemeService;

@RestController
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @GetMapping("/themes/{id}")
    public ThemeDto getThemeById(@PathVariable int id) {
        return themeService.getThemeById(id);
    }

    @GetMapping("/themes")
    public List<ThemeDto> getAllThemes() {
        return themeService.getAllThemes();
    }
    
    @PostMapping("/themes/register")
    public void registerTheme(@RequestBody ThemeDto themeDto) {
        themeService.registerTheme(themeDto);
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
