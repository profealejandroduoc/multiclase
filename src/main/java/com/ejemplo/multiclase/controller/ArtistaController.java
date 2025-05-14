package com.ejemplo.multiclase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.multiclase.model.Artista;
import com.ejemplo.multiclase.service.ArtistaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/artistas")
public class ArtistaController {
    @Autowired
    private ArtistaService artistaService;

    @GetMapping
    public ResponseEntity<List<Artista>> getArtistas() {
        List<Artista> artistas=artistaService.listarTodos();
        if( artistas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(artistas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Artista> postArtista(@RequestBody Artista artista) {
        Artista nuevo=artistaService.guardar(artista);
        if (nuevo==null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(artista,HttpStatus.CREATED);
    }
    
    
}
