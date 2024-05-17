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
public class Employee {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String nom;
private String prenom;
private String email;
private String adresse;
private float salaire;
@ManyToOne
@JoinColumn(name = "idequipe")
private Equipe equipe;
}
