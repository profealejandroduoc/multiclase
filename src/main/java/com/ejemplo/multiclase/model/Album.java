package com.ejemplo.multiclase.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="album")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_album;

    @Column(length = 250, nullable = false)
    private String titulo;

    @Column(nullable = false)
    private int year_publicacion;

    @ManyToOne()
    @JoinColumn(name = "id_artista" )
    @JsonBackReference // Aquí se evita la serialización en la parte "muchos"
    private Artista artista;

}
