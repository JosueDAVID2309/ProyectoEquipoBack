package com.bolsasenati.senati.tarea.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "bloques_seminario")
@Data
public class BloqueSeminario {

    @Id
    private String id;
    private String carrera;
    private String semestre;
    private String bloque;
    private Integer mensajes;

    @OneToMany(mappedBy = "bloque", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Tarea> tareas;

    @Transient
    public int getTareas() {
        return tareas != null ? tareas.size() : 0;
    }
}