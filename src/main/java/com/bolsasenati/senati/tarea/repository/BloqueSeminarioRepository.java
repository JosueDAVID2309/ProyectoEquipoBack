package com.bolsasenati.senati.tarea.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.bolsasenati.senati.tarea.model.BloqueSeminario;

@Repository
public interface BloqueSeminarioRepository extends JpaRepository<BloqueSeminario, Long> {
}