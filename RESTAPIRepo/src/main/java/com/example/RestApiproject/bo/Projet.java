package com.example.RestApiproject.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Projet {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int codeprojet;
    private String nom;
    private Date datedebut;
    private int duree;
    @ManyToOne
    @JoinColumn(name = "idequipe")
    private Equipe equipe;

}
