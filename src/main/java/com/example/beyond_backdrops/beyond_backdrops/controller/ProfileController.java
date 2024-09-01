package com.example.beyond_backdrops.beyond_backdrops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.beyond_backdrops.beyond_backdrops.Model.User;
import com.example.beyond_backdrops.beyond_backdrops.Repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public String profile(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String username = userDetails.getUsername();
        User user = userRepository.findByUsername(username);

        model.addAttribute("username", user.getUsername());
        model.addAttribute("dateJoined", user.getDateJoined());
        model.addAttribute("uploads", user.getUploads());
        model.addAttribute("favorites", user.getFavorites());
        model.addAttribute("profileViews", user.getProfileViews());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("userDesc", user.getUserDesc());



        return "profile";
    }
    
    @PostMapping("/profile")
    public String updateProfile(@ModelAttribute User user) {
        //TODO: process POST request
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();

        userRepository.save(user);
        
        return "redirect:/profile?username=" + user.getUsername();
    }
    

}
