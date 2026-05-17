package com.bolsasenati.senati.instructor.controller;

import com.bolsasenati.senati.instructor.model.Instructor;
import com.bolsasenati.senati.instructor.repository.InstructorRepository;
import com.bolsasenati.senati.shared.Response.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/instructor")
@CrossOrigin(originPatterns = "*")
public class InstructorController {

    private final InstructorRepository repo;

    public InstructorController(InstructorRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/login")
    public ApiResponse<?> login(@RequestBody Map<String, String> body) {
        String correo = body.get("correo");
        String clave = body.get("clave");

        Optional<Instructor> instructor = repo.loginInstructor(correo, clave);

        if (instructor.isPresent()) {
            return new ApiResponse<>(true, instructor.get(), "Inicio de sesión correcto");
        } else {
            return new ApiResponse<>(false, null, "Credenciales incorrectas");
        }
    }

    @PutMapping("/editar")
    public ApiResponse<?> actualizar(@RequestBody Instructor i) {
        try {
            repo.actualizarInstructor(
                i.getId(), i.getNombre(), i.getApellido(), 
                i.getTelefono(), i.getCorreoPersonal(), 
                i.getEspecialidad(), i.getImageurl()
            );
            return new ApiResponse<>(true, null, "Perfil actualizado correctamente");
        } catch (Exception e) {
            return new ApiResponse<>(false, null, "Error al actualizar: " + e.getMessage());
        }
    }

    @PutMapping("/cambiar-clave")
    public ApiResponse<?> cambiarClave(@RequestBody Map<String, Object> body) {
        try {
            Long id = Long.valueOf(body.get("id").toString());
            String nuevaClave = body.get("clave").toString();

            repo.cambiarPassword(id, nuevaClave);
            return new ApiResponse<>(true, null, "Contraseña cambiada con éxito");
        } catch (Exception e) {
            return new ApiResponse<>(false, null, "Error al cambiar contraseña: " + e.getMessage());
        }
    }
}