package com.ejemplo.multiclase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.multiclase.model.Album;
import com.ejemplo.multiclase.repository.AlbumRepository;

@Service
public class AlbumService { 
    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> albumes(){
        return albumRepository.findAll();
    }

    public Album guardar(Album album)
    {
        return albumRepository.save(album);
    }
}
