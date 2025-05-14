package com.ejemplo.multiclase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.multiclase.model.Artista;
import com.ejemplo.multiclase.repository.ArtistaRepository;

@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository artistaRepository;

    public List<Artista> listarTodos()
    {
        return artistaRepository.findAll();
    }

    public Artista guardar(Artista artista){
        return artistaRepository.save(artista);
    }

    public Artista artistaxId(int id)
    {
        return artistaRepository.getReferenceById(id);
    }
       
}
