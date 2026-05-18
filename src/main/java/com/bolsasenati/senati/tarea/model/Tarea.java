package com.bolsasenati.senati.tarea.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tareas")
@Data
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    
    @Column(name = "alumno_nombre")
    private String alumnoNombre;
    
    private String estado;
    private Double nota;
    private String retroalimentacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bloque_id")
    private BloqueSeminario bloque;
}