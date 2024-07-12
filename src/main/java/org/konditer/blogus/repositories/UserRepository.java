package org.konditer.blogus.repositories;

import java.util.List;

import org.konditer.blogus.domain.Theme;
import org.konditer.blogus.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT t FROM User AS u" +
                   "JOIN u.subscribes AS s" +
                   "JOIN s.blog AS b" +
                   "JOIN b.theme AS t" +
                   "WHERE u.id = :userId")
    List<Theme> findSubscribedBlogThemesByUserId();
}
