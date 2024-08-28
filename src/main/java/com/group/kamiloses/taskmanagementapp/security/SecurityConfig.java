package com.group.kamiloses.taskmanagementapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain customFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
         http.authorizeHttpRequests(request-> request.anyRequest().authenticated()//todo dostosuj by metody z graphql działały zaleznie od roli(jezeli sie tak da)
                 ).httpBasic(Customizer.withDefaults());
        return http.build();
    }


    @Bean
    public PasswordEncoder noopPasswordEncoder(){

        return NoOpPasswordEncoder.getInstance();
    }

}
