package com.konditer.blogus.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity @Table(name = "theme")
public class Theme extends BaseEntity {
    
    private String name;
    private List<Blog> blogs;

    public Theme() {}

    public Theme(String name) {
        super();
        this.name = name;
        this.blogs = new ArrayList<>();
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    @OneToMany(mappedBy = "theme")
    public List<Blog> getBlogs() {
        return this.blogs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
