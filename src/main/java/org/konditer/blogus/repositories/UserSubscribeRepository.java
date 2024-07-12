package org.konditer.blogus.repositories;

import org.konditer.blogus.domain.UserSubscribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSubscribeRepository extends JpaRepository<UserSubscribe, Integer> {

}
