package com.bolsasenati.senati.instructor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolsasenati.senati.instructor.model.Instructor;


public interface InstructorRepository extends JpaRepository<Instructor, Long>{
    Optional<Instructor> findByCorreoInstitucional(String correoInstitucional);
}
