package com.example.RestApiproject.controller;

import com.example.RestApiproject.dto.ProjetDTO;
import com.example.RestApiproject.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class ProjetController {
    @Autowired
    private ProjetService projetservice;

    @GetMapping("/projets")
    public List<ProjetDTO> getAllprojets() {
        return projetservice.getAllProjets();
    }

    @GetMapping("/projet/{id}")
    public ProjetDTO getprojet(@PathVariable(name="id") int id) {
        return projetservice.getProjet(id);
    }

    @PostMapping("/projet")
    public ProjetDTO createprojet(@RequestBody ProjetDTO ProjetDTO) {
        return projetservice.createProjet(ProjetDTO);

    }
    @PutMapping("/projet/{id}")
    public ProjetDTO updateprojet(@PathVariable(name="id") int id,@RequestBody ProjetDTO pdto) {
        return projetservice.updateProjet(id,pdto);
    }

    @DeleteMapping("/projet/{id}")
    public void deleteprojet(@PathVariable(name = "id") int id) {

        projetservice.deleteProjet(id);
    }
}
