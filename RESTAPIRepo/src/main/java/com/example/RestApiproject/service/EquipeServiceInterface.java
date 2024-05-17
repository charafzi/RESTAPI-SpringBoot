package com.example.RestApiproject.service;

import com.example.RestApiproject.dto.EquipeDTO;

import java.util.List;

public interface EquipeServiceInterface {
    List<EquipeDTO> getAllEquipe();
    EquipeDTO createEquipe(EquipeDTO equipedto);
    EquipeDTO updateEquipe(int id,EquipeDTO new_equipedto);
    void deleteEquipe(int id);
    EquipeDTO getEquipe(int id);
}
