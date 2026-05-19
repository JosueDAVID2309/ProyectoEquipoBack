package com.bolsasenati.senati.alumnos.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bolsasenati.senati.tarea.model.BloqueSeminario;
import com.bolsasenati.senati.tarea.model.Tarea;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_estudiante;
    private String nombres;
    private String apellidos;
    private String genero;
    private LocalDate f_nacimiento;
    private String correo;

    @OneToMany(mappedBy = "alumno")
    private List<Tarea> tareas = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "bloque_id")
    private BloqueSeminario bloque;
}
