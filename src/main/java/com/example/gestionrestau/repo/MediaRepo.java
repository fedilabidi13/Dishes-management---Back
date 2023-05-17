package com.example.gestionrestau.repo;

import com.example.gestionrestau.entities.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepo extends JpaRepository<Media, Integer> {
}
