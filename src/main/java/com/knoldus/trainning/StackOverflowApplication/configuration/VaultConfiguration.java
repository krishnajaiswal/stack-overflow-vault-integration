package com.knoldus.trainning.StackOverflowApplication.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VaultConfiguration {
//    @Value("${login}")
//    public String login;
//
//    @Value("${password}")
//    public String password;
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    @Value("${cid}")
    public String cid;

    @Value("${secret}")
    public String secret;

    public String getLogin() {
        return cid;
    }

    public void setLogin(String cid) {
        this.cid = cid;
    }

    public String getPassword() {
        return secret;
    }

    public void setPassword(String secret) {
        this.secret = secret;
    }
}
