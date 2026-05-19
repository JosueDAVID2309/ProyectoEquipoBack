package com.bolsasenati.senati.alumnos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsasenati.senati.alumnos.dto.AlumnoResponse;
import com.bolsasenati.senati.alumnos.service.AlumnoService;
import com.bolsasenati.senati.shared.Response.ApiResponse;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/alumno")
public class AlumnoController {
    
    private final AlumnoService service;

    public AlumnoController(AlumnoService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public ApiResponse<?> getAlumnosBloque(@PathVariable Long id) {
        try{
            List<AlumnoResponse> alumnos = service.getAlumnos(id);
            return new ApiResponse<List<AlumnoResponse>>(true, alumnos, "Alumnos Encontrados");
        }catch(RuntimeException e){
            return new ApiResponse<>(false, null, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ApiResponse<?> putMethodName(@PathVariable Long idBloque, @RequestBody String correo) {
        try{
            service.addAlumno(correo, idBloque);
            return new ApiResponse<>(true, null, "Alumno Añadido");
        }catch(RuntimeException e){
            return new ApiResponse<>(false, null, e.getMessage());
        }
    }
    
}
