package com.bolsasenati.senati.instructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolsasenati.senati.instructor.model.Horario;

public interface HorarioRepository extends JpaRepository<Horario, Long>{
    
}
