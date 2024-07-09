package com.example.html.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.html.demo.model.User;
import com.example.html.demo.repository.UserRepository;
import com.example.html.demo.service.UserService;


@Controller
public class RegisterController {

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
    public String registeredSuccess(@ModelAttribute User user){
        String rawPassword = user.getPassword();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println(user.toString());
        userService.saveUserDetails(user);

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user.getUsername(), rawPassword);
        try {
            SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate(authToken));
            System.out.println("Authentication successful for user: " + user.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Authentication failed for user: " + user.getUsername());
        }

        System.out.println("Current user: " + SecurityContextHolder.getContext().getAuthentication().getName());


        return "redirect:/home";
    }
}
