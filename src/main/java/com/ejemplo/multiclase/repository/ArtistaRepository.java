package com.ejemplo.multiclase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplo.multiclase.model.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer> {
    // los metodos vienen heredados
}
