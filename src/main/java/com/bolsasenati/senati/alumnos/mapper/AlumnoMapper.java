package com.bolsasenati.senati.alumnos.mapper;

import com.bolsasenati.senati.alumnos.dto.AlumnoResponse;
import com.bolsasenati.senati.alumnos.model.Alumno;

public class AlumnoMapper {
    public AlumnoResponse toDTO(Alumno alumno,
        Double pea_avance,
        Double tareas_avance,
        Double operaciones_avance){
            AlumnoResponse response = new AlumnoResponse();

            response.setId_estudiante(alumno.getId_estudiante());
            response.setNombres(alumno.getNombres());
            response.setApellidos(alumno.getApellidos());
            response.setCorreo(alumno.getCorreo());
            response.setPea_avance(pea_avance);
            response.setTareas_avance(tareas_avance);
            response.setOperaciones_avance(operaciones_avance);

            return response;
    }
}
