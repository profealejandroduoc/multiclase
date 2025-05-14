package com.ejemplo.multiclase.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.multiclase.model.Album;
import com.ejemplo.multiclase.model.Artista;
import com.ejemplo.multiclase.service.AlbumService;
import com.ejemplo.multiclase.service.ArtistaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/albums")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @Autowired
    private ArtistaService artistaService;

    @GetMapping
    public ResponseEntity<List<Album>> getAlbums() {
        List<Album> albums= albumService.albumes();
        if(albums.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(albums,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Album> postAlbum(@RequestBody Album album) {
        int id_link=album.getArtista().getId_artista();
        System.out.println("ID A VINCULAR: " + id_link);
        Artista artista=artistaService.artistaxId(id_link);
        if (artista!=null)
        {
            album.setArtista(artista);
        }

        Album nuevo= albumService.guardar(album);
        if(nuevo==null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(nuevo,HttpStatus.CREATED);
        
    }
    
    
}
