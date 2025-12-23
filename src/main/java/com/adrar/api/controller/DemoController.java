package com.adrar.api.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/me")
    public String me(Authentication authentication) {
        return "Connecté en tant que " + authentication.getName();
    }
}
