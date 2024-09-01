package com.example.beyond_backdrops.beyond_backdrops.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.beyond_backdrops.beyond_backdrops.Model.Wallpaper;

@Repository
public interface WallpaperRepository extends JpaRepository<Wallpaper,Long>{
    
}
