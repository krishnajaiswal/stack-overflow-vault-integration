package com.knoldus.trainning.StackOverflowApplication.config;//package com.knoldus.trainning.StackOverflowApplication.config;
//
//import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
//import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
//import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
//import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Import;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
//import org.springframework.security.core.session.SessionRegistryImpl;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
//import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
//
//@KeycloakConfiguration
//@EnableGlobalMethodSecurity(jsr250Enabled = true)
//@Order(1000)
//@Import(KeycloakSpringBootConfigResolver.class)
//public class SecurityConfigWithKeycloak extends KeycloakWebSecurityConfigurerAdapter {
//
//
//    @Autowired private UserDetailsService userDetailsService;
//
//
//
//    private static final String[] AUTH_LIST = {
//            // -- swagger ui
//            "**/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs", "/webjars/**"
//    };
//
//    /**
//     * Registers the KeycloakAuthenticationProvider with the authentication manager.
//     */
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        KeycloakAuthenticationProvider authenticationProvider = new KeycloakAuthenticationProvider();
//        authenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
//        auth.authenticationProvider(authenticationProvider);
//    }
//
//    /**
//     * Defines the session authentication strategy.
//     */
//    @Bean
//    @Override
//    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        http
//                .authorizeRequests()
//                .anyRequest().authenticated();
//
////        http
////                .authorizeRequests()
////                .antMatchers("/", "/new", "/save")
////                .permitAll()
////                .anyRequest()
////                .authenticated();
//
//
////        http.authorizeRequests()
////                .antMatchers(AUTH_LIST)
////                .permitAll()
////                .antMatchers("/", "/new", "/save")
////                .permitAll()
////                .anyRequest()
////                .authenticated()
////                .and()
////                .formLogin()
////                .and()
////                .oauth2Login()
////                .and()
////                .httpBasic();
//    }
//}
