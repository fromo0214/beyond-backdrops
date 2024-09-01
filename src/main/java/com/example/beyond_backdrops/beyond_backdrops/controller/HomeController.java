package com.example.beyond_backdrops.beyond_backdrops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.beyond_backdrops.beyond_backdrops.Model.User;
import com.example.beyond_backdrops.beyond_backdrops.Repository.UserRepository;


@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/home")
    public String home(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        UserDetails userDetails = (UserDetails) auth.getPrincipal();

        String username = userDetails.getUsername();
        User user = userRepository.findByUsername(username);

        if(user != null){
            return "home";
        }


        return "redirect:/login";


    }
    


}
