package com.learn.employeeservice.security;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity,
    HttpServletRequest httpServletRequest) throws Exception{
        httpSecurity.formLogin(login -> login.loginPage("/login")
                .defaultSuccessUrl(httpServletRequest.getQueryString()).failureForwardUrl(""));

//        log.info(httpServletRequest.getPathInfo()+" path info");
//        log.info(httpServletRequest.getContextPath()+" context path");
////        log.info(httpServletRequest.getPathTranslated()+" path translated");
//        log.info(httpServletRequest.getQueryString()+" query string");

        return httpSecurity.build();
    }
}
