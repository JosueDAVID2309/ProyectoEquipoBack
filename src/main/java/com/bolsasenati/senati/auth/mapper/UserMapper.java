package com.bolsasenati.senati.auth.mapper;

import org.springframework.stereotype.Component;

import com.bolsasenati.senati.auth.dto.RegisterRequest;
import com.bolsasenati.senati.instructor.model.Instructor;

@Component
public class UserMapper {

    public Instructor toEntity(RegisterRequest request){
        Instructor user = new Instructor();
        user.setNombres(request.getNombres());
        user.setApellidos(request.getApellidos());
        user.setGenero(request.getGenero());
        user.setDni(request.getDni());
        user.setTelefono(request.getTelefono());
        user.setImageurl(request.getImageurl());
        user.setCorreoPersonal(request.getCorreoPersonal());
        user.setEspecialidad(request.getEspecialidad());

        return user;
    }

}
