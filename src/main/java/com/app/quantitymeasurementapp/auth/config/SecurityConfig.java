package com.app.quantitymeasurementapp.auth.config;

import com.app.quantitymeasurementapp.auth.service.CustomOAuth2UserService;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final CustomOAuth2UserService oAuth2UserService;

    public SecurityConfig(CustomOAuth2UserService oAuth2UserService) {
        this.oAuth2UserService = oAuth2UserService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/oauth2/**", "/auth/**").permitAll()
                .anyRequest().authenticated() // Protect UC17 APIs
                )
                .oauth2Login(oauth -> oauth
                .userInfoEndpoint(user -> user.userService(oAuth2UserService))
                .defaultSuccessUrl("/auth/success", true)
                )
                .logout(logout -> logout
                .logoutUrl("/auth/logout")
                .logoutSuccessUrl("/")
                );

        return http.build();
    }
}
