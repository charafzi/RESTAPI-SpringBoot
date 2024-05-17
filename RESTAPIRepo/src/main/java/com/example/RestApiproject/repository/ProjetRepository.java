package com.example.RestApiproject.repository;

import com.example.RestApiproject.bo.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepository extends JpaRepository<Projet,Integer> {
}
