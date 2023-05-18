package com.example.gestionrestau.servicesImpl;


import com.cloudinary.Cloudinary;
import com.example.gestionrestau.entities.Media;
import com.example.gestionrestau.entities.Plat;
import com.example.gestionrestau.repo.MediaRepo;
import com.example.gestionrestau.repo.PlatRepo;
import com.example.gestionrestau.services.PlatService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PlatImpl implements PlatService {
    private final PlatRepo platRepo;
    private final MediaRepo mediaRepo;
    Cloudinary cloudinary;
    @Override
    public Plat addPlat(Plat plat, MultipartFile file) throws IOException {
        plat.setPrix(plat.getPrix()+" TND");
        Media media = new Media();
        String url = cloudinary.uploader()
                .upload(file.getBytes(),
                        Map.of("public_id", UUID.randomUUID().toString()))
                .get("url")
                .toString();
        media.setImagenUrl(url);
        media.setName(file.getName());
        plat.setMedia(mediaRepo.save(media));
        return platRepo.save(plat);
    }

    @Override
    public Plat update(Plat plat, MultipartFile file) throws IOException {
        plat.setPrix(plat.getPrix()+" TND");
        Media media = new Media();
        String url = cloudinary.uploader()
                .upload(file.getBytes(),
                        Map.of("public_id", UUID.randomUUID().toString()))
                .get("url")
                .toString();
        media.setImagenUrl(url);
        media.setName(file.getName());
        plat.setMedia(mediaRepo.save(media));
        return platRepo.save(plat);
    }

    @Override
    public List<Plat> getAll() {
        return platRepo.findAll();
    }

    @Override
    public Plat getPlat(Integer id) {
        return platRepo.getReferenceById(id);
    }

    @Override
    public String delete(Integer id) {
         platRepo.deleteById(id);
         return "deleted!";
    }
}
