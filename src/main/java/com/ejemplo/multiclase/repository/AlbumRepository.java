package com.ejemplo.multiclase.repository;

import org.springframework.stereotype.Repository;

import com.ejemplo.multiclase.model.Album;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer>  {
    // metodos heredados
}
