package com.example.beyond_backdrops.beyond_backdrops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.beyond_backdrops.beyond_backdrops.Model.User;
import com.example.beyond_backdrops.beyond_backdrops.Service.UserService;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class RegistrationController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String postMethodName(@ModelAttribute User user, Model model) {
        //TODO: process POST request

        String rawPassword = user.getPassword();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user.getUsername(), rawPassword);

         try {
            SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate(authToken));
            System.out.println("Authentication successful for user: " + user.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Authentication failed for user: " + user.getUsername());
        }
        
        return "redirect:/login?registered=true";
    }
    
    

}
