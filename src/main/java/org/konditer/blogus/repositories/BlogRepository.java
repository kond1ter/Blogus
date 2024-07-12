package org.konditer.blogus.repositories;

import java.util.List;

import org.konditer.blogus.domain.Blog;
import org.konditer.blogus.domain.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "SELECT b FROM Blog AS b" +
                   "JOIN b.theme AS t WHERE t IN :themes")
    List<Blog> findByThemes(@Param(value = "theme") List<Theme> themes);

    @Query(value = "SELECT b FROM Blog AS b" +
                   "ORDER BY b.rating")
    List<Blog> findOrderByRating();
}
