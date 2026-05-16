package com.bolsasenati.senati.instructor.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "instructor")
public class Instructor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String nombres;

    @Column(nullable=false)
    private String apellidos;

    @Column(nullable=false)
    private String genero;

    @Column(nullable = false, length = 8, unique = true)
    private String dni;

    private String telefono;

    @Column(nullable=false)
    private String imageurl;

    @Column(nullable = false, unique = true)
    private String correoInstitucional;

    @Column(nullable = false)
    private String clave;

    @Column(nullable = false, unique = true)
    private String correoPersonal;

    @Column(nullable = false)
    private String especialidad;
}
