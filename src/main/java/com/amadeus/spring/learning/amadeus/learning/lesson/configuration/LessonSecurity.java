package com.amadeus.spring.learning.amadeus.learning.lesson.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class LessonSecurity {

  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build();

    UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("adminpassword").roles("USER", "ADMIN").build();

    return new InMemoryUserDetailsManager(user, admin);
  }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http
              .authorizeHttpRequests(authorizeRequests ->
                      authorizeRequests
                              .requestMatchers("/api/v1/lessons/getAllLessons").hasAnyRole("USER","ADMIN")
                              .requestMatchers("/api/v1/lessons/addLesson").hasAnyRole("ADMIN")
                              .requestMatchers("/api/v1/lessons/deleteLesson").hasAnyRole("ADMIN")
                              .anyRequest().authenticated()
              ).httpBasic(withDefaults())
              .formLogin(withDefaults())
              .csrf().disable();
      return http.build();
    }
  }
