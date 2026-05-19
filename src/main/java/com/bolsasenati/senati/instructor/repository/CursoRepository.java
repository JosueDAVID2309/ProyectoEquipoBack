package com.bolsasenati.senati.instructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolsasenati.senati.instructor.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{
    
}
