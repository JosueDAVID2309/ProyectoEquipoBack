package com.bolsasenati.senati.tarea.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

import com.bolsasenati.senati.alumnos.model.Alumno;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "bloques_seminario")
@Data
public class BloqueSeminario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String carrera;
    private String semestre;
    private String bloque;
    private Integer mensajes;

    @OneToMany(mappedBy = "bloque", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Tarea> tareas;

    @OneToMany(mappedBy = "bloque")
    private List<Alumno> alumnos;

    @Transient
    public int getTareas() {
        return tareas != null ? tareas.size() : 0;
    }
}