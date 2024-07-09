package com.example.html.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.html.demo.model.User;
import com.example.html.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initializeUsers(){
        User user1 = new User("test1", "hello1@gmail.com", passwordEncoder.encode("test"));
        saveUserDetails(user1);

        User user2 = new User("test2", "hello2@gmail.com", passwordEncoder.encode("test"));
        saveUserDetails(user2);

        User user3 = new User("test3", "hello3@gmail.com", passwordEncoder.encode("test"));
        saveUserDetails(user3);

        User user4 = new User("test4", "hello4@gmail.com", passwordEncoder.encode("test"));
        saveUserDetails(user4);

        User user5 = new User("test5", "hello5@gmail.com", passwordEncoder.encode("test"));
        saveUserDetails(user5);

        
        User user6 = new User("user", "hello6@gmail.com", passwordEncoder.encode("password"));
        saveUserDetails(user6);

    }



    public User saveUserDetails(User user){

        return userRepository.save(user);
        
    } 

}