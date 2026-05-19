package com.bolsasenati.senati.alumnos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bolsasenati.senati.alumnos.dto.AlumnoResponse;
import com.bolsasenati.senati.alumnos.mapper.AlumnoMapper;
import com.bolsasenati.senati.alumnos.model.Alumno;
import com.bolsasenati.senati.alumnos.repository.AlumnoRepository;
import com.bolsasenati.senati.tarea.model.BloqueSeminario;
import com.bolsasenati.senati.tarea.repository.BloqueSeminarioRepository;

@Service
public class AlumnoService {
    private final AlumnoRepository alumnoRepo;
    private final BloqueSeminarioRepository bloqueRepo;
    private final AlumnoMapper mapper;

    public AlumnoService(AlumnoRepository alumnoRepo,
        BloqueSeminarioRepository bloqueRepo,
        AlumnoMapper mapper
    ){
        this.alumnoRepo = alumnoRepo;
        this.bloqueRepo = bloqueRepo;
        this.mapper = mapper;
    }

    public List<AlumnoResponse> getAlumnos(Long id){
        BloqueSeminario bloque = bloqueRepo.findById(id).orElseThrow();
        List<Alumno> alumnos = bloque.getAlumnos();
        List<AlumnoResponse> response = new ArrayList<>();

        for(Alumno alumno : alumnos){
            double avancePea = 0.0;
            double avanceTareas = alumno.getTareas().size()/bloque.getTareas();
            double avanceOperaciones = 0.0;
            response.add(mapper.toDTO(alumno, avancePea, avanceTareas, avanceOperaciones));
        }
        return response;
    }

    public void addAlumno(String correo, Long idBloque){
        BloqueSeminario bloque = bloqueRepo.findById(idBloque).orElseThrow();
        Alumno alumno = alumnoRepo.findByCorreo(correo).orElseThrow();

        bloque.getAlumnos().add(alumno);
        bloqueRepo.save(bloque);
    }
}
