package com.portafolio.dish.webapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAuthWebSecurityConfiguration {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
         .authorizeRequests().anyRequest().authenticated()
         .and()
         .httpBasic();

    return http.build();
  }

  @Bean
  public InMemoryUserDetailsManager adminDetailsService() {
    UserDetails admin = User
        .withUsername("user")
        .password(passwordEncoder().encode("user"))
        .roles("USER")
        .build();
    return new InMemoryUserDetailsManager(admin);
  }

  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    UserDetails user = User
        .withUsername("admin")
        .password("admin")
        .roles("ADMIN")
        .build();
    return new InMemoryUserDetailsManager(user);
  }

  @Bean
  PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
}
