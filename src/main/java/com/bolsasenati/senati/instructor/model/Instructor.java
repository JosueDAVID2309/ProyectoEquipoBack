package com.bolsasenati.senati.instructor.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "instructor")
@Data
@NoArgsConstructor
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String genero;
    private String dni;
    private String telefono;
    private String imageurl;

    @Column(name = "correo_institucional")
    private String correoInstitucional;

    private String clave;

    @Column(name = "correo_personal")
    private String correoPersonal;

    private String especialidad;
}