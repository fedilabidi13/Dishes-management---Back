package com.example.gestionrestau.repo;

import com.example.gestionrestau.entities.Plat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatRepo extends JpaRepository<Plat, Integer> {
}
