package com.knoldus.trainning.StackOverflowApplication.repository;

import com.knoldus.trainning.StackOverflowApplication.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  User findByUsername(String username);
//  User findByUsername(String username);
}
