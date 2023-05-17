package com.example.gestionrestau.services;

import com.example.gestionrestau.entities.Plat;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PlatService {
    Plat addPlat(Plat plat, MultipartFile file) throws IOException;
    Plat update (Plat plat, MultipartFile file) throws IOException;
    List<Plat> getAll();
    Plat getPlat(Integer id);
    String delete(Integer id);
}
