package com.knoldus.trainning.StackOverflowApplication.service;

import com.knoldus.trainning.StackOverflowApplication.entity.User;
import com.knoldus.trainning.StackOverflowApplication.repository.UserRepository;
import com.knoldus.trainning.StackOverflowApplication.securityConfig.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

  @Autowired private UserRepository repo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = repo.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("Not Found");
    }
    return new UserPrinciple(user);
  }
}
