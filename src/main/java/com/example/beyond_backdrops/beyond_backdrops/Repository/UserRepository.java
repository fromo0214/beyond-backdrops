package com.example.beyond_backdrops.beyond_backdrops.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.beyond_backdrops.beyond_backdrops.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);

}
