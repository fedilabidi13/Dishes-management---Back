package com.example.gestionrestau.controllers;

import com.example.gestionrestau.entities.Plat;
import com.example.gestionrestau.services.PlatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class PlatController {
    private PlatService platService;
    @GetMapping("/findAll")
    private List<Plat> listPlat()
    {
        return platService.getAll();
    }
    @PostMapping("/add")
    private Plat addPlat(@ModelAttribute Plat plat, @RequestParam MultipartFile file) throws IOException {
        return platService.addPlat(plat,file );
    }
    @PostMapping("/update")
    private Plat updatePlat(@ModelAttribute Plat plat , @RequestParam MultipartFile file) throws IOException {
        return platService.update(plat, file);
    }
    @PostMapping("/delete")
    private String deletePlat(@RequestParam Integer id)
    {
        return platService.delete(id);
    }
    @GetMapping("/get")
    private Plat getPlat (@RequestParam Integer id)
    {
        return platService.getPlat(id);
    }
}
