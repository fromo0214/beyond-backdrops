package com.example.beyond_backdrops.beyond_backdrops.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
    
@GetMapping("/login")
public String login() {
    return "login";
}

    

}
