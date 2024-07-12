package org.konditer.blogus.repositories;

import org.konditer.blogus.domain.BlogNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogNoteRepository extends JpaRepository<BlogNote, Integer> {

}
