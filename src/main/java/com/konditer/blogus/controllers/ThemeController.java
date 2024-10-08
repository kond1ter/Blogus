package com.konditer.blogus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/themes/all")
    public List<ThemeDto> getAll() {
        return themeService.getAll();
    }
    
    @PostMapping("/themes/register")
    public void register(@RequestBody ThemeDto themeDto) {
        themeService.register(themeDto);
    }
    
    @DeleteMapping("/themes/remove")
    public void remove(@RequestParam int id) {
        themeService.remove(id);
    }
}
