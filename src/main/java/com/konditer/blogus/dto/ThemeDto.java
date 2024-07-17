package com.konditer.blogus.dto;

public class ThemeDto {
    private String name;

    public ThemeDto() {}

    public ThemeDto(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
