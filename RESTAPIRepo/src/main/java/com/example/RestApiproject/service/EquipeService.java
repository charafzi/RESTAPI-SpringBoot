package com.example.RestApiproject.service;

import com.example.RestApiproject.bo.Employee;
import com.example.RestApiproject.bo.Equipe;
import com.example.RestApiproject.dto.EquipeDTO;
import com.example.RestApiproject.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class EquipeService implements EquipeServiceInterface{
    @Autowired
    private EquipeRepository equiperepository;
    @Override
    public List<EquipeDTO> getAllEquipe() {
        return equiperepository.findAll().stream()
                .map(e->this.fromEquipe(e))
                .collect(Collectors.toList());
    }

    @Override
    public EquipeDTO createEquipe(EquipeDTO equipedto) {
        return this.fromEquipe(equiperepository.save(this.toEquipe(equipedto)));
    }

    @Override
    public EquipeDTO updateEquipe(int id, EquipeDTO new_equipedto) {
        Optional<Equipe> old_equipe=equiperepository.findById(id);

        if(old_equipe.isPresent()) {
            Equipe update_equipe=old_equipe.get();

            update_equipe.setNom(new_equipedto.getNom());
            return this.fromEquipe(equiperepository.save(update_equipe));
        }
        else
            throw new RuntimeException("Equipe not found");
    }

    @Override
    public void deleteEquipe(int id) {
        equiperepository.deleteById(id);
    }

    @Override
    public EquipeDTO getEquipe(int id) {
        Optional<Equipe> equipe=equiperepository.findById(id);
        if(equipe.isPresent())
            return this.fromEquipe(equipe.get());
        else
            return null;
    }

    public Equipe toEquipe(EquipeDTO edto)
    {
        return Equipe.builder()
                .idequipe(edto.getIdequipe())
                .nom(edto.getNom())
                .employees(edto.getEmployees())
                .build();
    }
    public EquipeDTO fromEquipe(Equipe e)
    {
        return EquipeDTO.builder()
                .idequipe(e.getIdequipe())
                .nom(e.getNom())
                .build();
    }
}
