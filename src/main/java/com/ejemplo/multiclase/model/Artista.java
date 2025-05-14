package com.ejemplo.multiclase.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "artista")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_artista;

    @Column(length = 250, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Album> discografia;
    
}
