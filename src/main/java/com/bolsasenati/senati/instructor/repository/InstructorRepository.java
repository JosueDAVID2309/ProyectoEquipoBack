package com.bolsasenati.senati.instructor.repository;

import com.bolsasenati.senati.instructor.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    @Query(value = "CALL sp_login_instructor(:correo, :clave)", nativeQuery = true)
    Optional<Instructor> loginInstructor(@Param("correo") String correo, @Param("clave") String clave);

    @Transactional
    @Modifying
    @Query(value = "CALL sp_actualizar_instructor(:id, :nombre, :apellido, :telefono, :correoPersonal, :especialidad, :imageurl)", nativeQuery = true)
    void actualizarInstructor(
        @Param("id") Long id,
        @Param("nombre") String nombre,
        @Param("apellido") String apellido,
        @Param("telefono") String telefono,
        @Param("correoPersonal") String correoPersonal,
        @Param("especialidad") String especialidad,
        @Param("imageurl") String imageurl
    );

    @Transactional
    @Modifying
    @Query(value = "CALL sp_cambiar_password(:id, :clave)", nativeQuery = true)
    void cambiarPassword(@Param("id") Long id, @Param("clave") String clave);
}