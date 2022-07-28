package com.knoldus.trainning.StackOverflowApplication.controller;

import com.knoldus.trainning.StackOverflowApplication.CO.UserCO;
import com.knoldus.trainning.StackOverflowApplication.entity.User;
import com.knoldus.trainning.StackOverflowApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;

@RestController
public class HomeController {
  @Autowired private UserRepository userRepository;

  @GetMapping("/")
  public ModelAndView homePage() {
    ModelAndView mv = new ModelAndView("home");
    return mv;
  }

  @GetMapping("/new")
  public ModelAndView newForm() {
    ModelAndView mv = new ModelAndView("user_form");
    mv.addObject("user", new UserCO());
    return mv;
  }

  @PostMapping("/save")
  public ModelAndView save(@ModelAttribute("UserCO") UserCO userCO) {
    ModelAndView mv = new ModelAndView("redirect:/");
    User user =
        new User(
            userCO.getId(),
            userCO.getUsername(),
            userCO.getEmail(),
            userCO.getPassword(),
            userCO.getAddress());
    userRepository.save(user);
    return mv;
  }

  /**
   * @return home page .
   */
  @GetMapping("/user/home")
  @RolesAllowed("admin")
  public String userDetails() {
    return "Hello";
  }
}
