package com.example.RestApiproject.service;

import com.example.RestApiproject.bo.Equipe;
import com.example.RestApiproject.bo.Projet;
import com.example.RestApiproject.dto.ProjetDTO;
import com.example.RestApiproject.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjetService implements ProjetServiceInterface {
    @Autowired
    private ProjetRepository projetrepository;
    @Autowired
    private EquipeService equipeService;
    @Override
    public List<ProjetDTO> getAllProjets() {
        return projetrepository.findAll().stream()
                .map(p->this.fromProjet(p))
                .collect(Collectors.toList());
    }

    @Override
    public ProjetDTO createProjet(ProjetDTO projetdto) {
        return this.fromProjet(projetrepository.save(this.toProjet(projetdto)));
    }

    @Override
    public ProjetDTO updateProjet(int id, ProjetDTO new_projetdto) {
        Optional<Projet> old_p=projetrepository.findById(id);

        if(old_p.isPresent()) {
            Projet update_p=old_p.get();

            update_p.setNom(new_projetdto.getNom());
            update_p.setDatedebut(new_projetdto.getDatedebut());
            update_p.setDuree(new_projetdto.getDuree());
            return this.fromProjet(projetrepository.save(update_p));
        }
        else
            throw new RuntimeException("Projet not found");
    }

    @Override
    public void deleteProjet(int id) {
        projetrepository.deleteById(id);
    }

    @Override
    public ProjetDTO getProjet(int id) {
        Optional<Projet> projet= projetrepository.findById(id);
        if(projet.isPresent())
            return this.fromProjet(projet.get());
        else
            return null;
    }

    private ProjetDTO fromProjet(Projet p)
    {
        return ProjetDTO.builder()
                .codeprojet(p.getCodeprojet())
                .nom(p.getNom())
                .datedebut(p.getDatedebut())
                .duree(p.getDuree())
                .equipe(equipeService.fromEquipe(p.getEquipe()))
                .build();
    }

    private Projet toProjet(ProjetDTO pdto)
    {
        return Projet.builder()
                .codeprojet(pdto.getCodeprojet())
                .nom(pdto.getNom())
                .datedebut(pdto.getDatedebut())
                .duree(pdto.getDuree())
                .equipe(equipeService.toEquipe(pdto.getEquipe()))
                .build();
    }
}
