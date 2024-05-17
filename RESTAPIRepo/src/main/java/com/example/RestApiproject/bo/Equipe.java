package com.example.RestApiproject.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idequipe;
    private String nom;
    @OneToMany(mappedBy = "equipe", fetch = FetchType.LAZY)
    private List<Employee> employees;
    @OneToMany(mappedBy = "equipe", fetch = FetchType.LAZY)
    private List<Projet> projets;


}
