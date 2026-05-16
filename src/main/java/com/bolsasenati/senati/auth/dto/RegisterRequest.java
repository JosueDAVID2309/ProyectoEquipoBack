package com.bolsasenati.senati.auth.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
public class RegisterRequest {
    
    private String nombres;

    private String apellidos;

    private String genero;

    private String dni;

    private String telefono;

    private String imageurl;

    private String correoPersonal;

    private String especialidad;
}
