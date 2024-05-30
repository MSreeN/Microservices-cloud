package com.learn.employeeservice.security;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UrlPathHelper;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.formLogin(login -> login.loginPage("/login").defaultSuccessUrl("/hello"));
        return httpSecurity.build();
    }
}
