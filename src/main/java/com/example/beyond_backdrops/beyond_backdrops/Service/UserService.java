package com.example.beyond_backdrops.beyond_backdrops.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beyond_backdrops.beyond_backdrops.Model.User;
import com.example.beyond_backdrops.beyond_backdrops.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

}
