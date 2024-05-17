package com.example.RestApiproject.dto;

import com.example.RestApiproject.bo.Equipe;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjetDTO {
    private int codeprojet;
    private String nom;
    private Date datedebut;
    private int duree;
    private EquipeDTO equipe;
}
