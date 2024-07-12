package org.konditer.blogus.repositories;

import java.util.List;

import org.konditer.blogus.domain.Blog;
import org.konditer.blogus.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query(value = "SELECT c FROM Comment AS c" +
                   "JOIN c.author AS a" +
                   "JOIN c.blogNote AS b" +
                   "WHERE b.id = :blogNoteId" +
                   "ORDER BY a.rating")
    List<Blog> findByBlogNoteIdOrderByAuthorRating(@Param(value = "blogNoteId") int blogNoteId);
}
