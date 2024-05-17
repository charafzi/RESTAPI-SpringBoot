package com.example.RestApiproject.service;

import com.example.RestApiproject.dto.ProjetDTO;
import com.example.RestApiproject.dto.ProjetDTO;

import java.util.List;

public interface ProjetServiceInterface {
    List<ProjetDTO> getAllProjets();
    ProjetDTO createProjet(ProjetDTO projetdto);
    ProjetDTO updateProjet(int id,ProjetDTO new_projetdto);
    void deleteProjet(int id);
    ProjetDTO getProjet(int id);
}
