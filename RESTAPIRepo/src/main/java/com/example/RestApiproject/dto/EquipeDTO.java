package com.example.RestApiproject.dto;

import com.example.RestApiproject.bo.Employee;
import com.example.RestApiproject.bo.Projet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EquipeDTO {
    private int idequipe;
    private String nom;
    private List<Employee> employees;
    private List<ProjetDTO> projets;
}
