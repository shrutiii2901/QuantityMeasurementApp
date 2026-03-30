package com.app.quantitymeasurementapp.auth.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    // After Google login
    @GetMapping("/success")
    public String loginSuccess(@AuthenticationPrincipal OAuth2User user) {

        String name = user.getAttribute("name");
        String email = user.getAttribute("email");

        return "Welcome " + name + " (" + email + ")";
    }

    // Check current user
    @GetMapping("/me")
    public OAuth2User currentUser(@AuthenticationPrincipal OAuth2User user) {
        return user;
    }
}