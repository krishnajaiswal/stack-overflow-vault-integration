package com.knoldus.trainning.StackOverflowApplication.securityConfig;//package com.knoldus.trainning.StackOverflowApplication.securityConfig;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfigurationWithChanges extends WebSecurityConfigurerAdapter {
//
//  @Autowired private UserDetailsService userDetailsService;
//
//
//  private static final String[] AUTH_LIST = {
//    // -- swagger ui
//    "**/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs", "/webjars/**"
//  };
//
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
////    http.authorizeRequests()
////        .antMatchers(AUTH_LIST)
////        .permitAll()
////        .antMatchers("/", "/new", "/save")
////        .permitAll()
////        .anyRequest()
////        .authenticated()
////        .and()
////        .formLogin()
////            .and()
////            .oauth2Login()
////        .and()
////        .httpBasic()
////            .and().csrf().disable();
//
//
//
//    http.authorizeRequests()
//            .antMatchers(AUTH_LIST)
//            .permitAll()
//            .antMatchers("/", "/new", "/save")
//            .permitAll()
//            .anyRequest()
//            .authenticated()
//            .and()
//            .formLogin()
//            .and()
//            .oauth2Login()
//            .and()
//            .httpBasic()
//            .and().csrf().disable();
//  }
//}
