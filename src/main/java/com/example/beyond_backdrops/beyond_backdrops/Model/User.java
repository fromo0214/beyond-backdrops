package com.example.beyond_backdrops.beyond_backdrops.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String email;

    private String username;

    private String password;

    private Long profileViews;

    private Long favorites;

    private Long uploads;

    private LocalDate dateJoined;

    private String userDesc;

    public User(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Long getProfileViews() {
        return profileViews;
    }


    public void setProfileViews(Long profileViews) {
        this.profileViews = profileViews;
    }


    public Long getFavorites() {
        return favorites;
    }


    public void setFavorites(Long favorites) {
        this.favorites = favorites;
    }


    public Long getUploads() {
        return uploads;
    }


    public void setUploads(Long uploads) {
        this.uploads = uploads;
    }


    public LocalDate getDateJoined() {
        return dateJoined;
    }


    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }





    public String getUserDesc() {
        return userDesc;
    }





    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }


    
    

}
