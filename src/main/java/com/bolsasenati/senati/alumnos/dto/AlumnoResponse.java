package com.bolsasenati.senati.alumnos.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
public class AlumnoResponse {
    private Long id_estudiante;
    private String nombres;
    private String apellidos;
    private String correo;
    private Double pea_avance;
    private Double tareas_avance;
    private Double operaciones_avance;
}
