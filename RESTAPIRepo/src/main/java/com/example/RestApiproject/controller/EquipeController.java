package com.example.RestApiproject.controller;

import com.example.RestApiproject.dto.EmployeeDTO;
import com.example.RestApiproject.dto.EquipeDTO;
import com.example.RestApiproject.service.EmployeeService;
import com.example.RestApiproject.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class EquipeController {
    @Autowired
    private EquipeService equipeservice;

    @GetMapping("/equipes")
    public List<EquipeDTO> getAllEquipes() {
        return equipeservice.getAllEquipe();
    }

    @GetMapping("/equipe/{id}")
    public EquipeDTO getEquipe(@PathVariable(name="id") int id) {
        return equipeservice.getEquipe(id);
    }

    @PostMapping("/equipe")
    public EquipeDTO createEquipe(@RequestBody EquipeDTO equipedto) {
        return equipeservice.createEquipe(equipedto);

    }
    @PutMapping("/equipe/{id}")
    public EquipeDTO updateEquipe(@PathVariable(name="id") int id,@RequestBody EquipeDTO equipedto) {
        return equipeservice.updateEquipe(id,equipedto);
    }

    @DeleteMapping("/equipe/{id}")
    public void deleteEquipe(@PathVariable(name = "id") int id) {

        equipeservice.deleteEquipe(id);
    }
}
