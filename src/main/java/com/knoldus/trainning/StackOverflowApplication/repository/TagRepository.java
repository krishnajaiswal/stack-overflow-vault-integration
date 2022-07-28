package com.knoldus.trainning.StackOverflowApplication.repository;

import com.knoldus.trainning.StackOverflowApplication.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByName(String name);

//  Optional<Tag> findByName(String name);
}
