package com.bolsasenati.senati.tarea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolsasenati.senati.tarea.model.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByBloqueId(String bloqueId);
}