package com.bolsasenati.senati.alumnos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolsasenati.senati.alumnos.model.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long>{
    Optional<Alumno> findByCorreo(String correo);
}
