package org.konditer.blogus.domain;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity @Table(name = "theme")
public class Theme extends BaseEntity {
    private String name;
    private Set<Blog> blogs;

    public Theme() {}

    public Theme(String name, Set<Blog> blogs) {
        this.setName(name);
        this.setBlogs(blogs);
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    @OneToMany(mappedBy = "theme")
    public Set<Blog> getBlogs() {
        return this.blogs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }
}
