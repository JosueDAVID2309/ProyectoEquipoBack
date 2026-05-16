package com.bolsasenati.senati.auth.controller;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsasenati.senati.auth.dto.LoginRequest;
import com.bolsasenati.senati.auth.dto.RegisterRequest;
import com.bolsasenati.senati.auth.service.AuthService;
import com.bolsasenati.senati.instructor.model.Instructor;
import com.bolsasenati.senati.shared.Response.ApiResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService service;

    public AuthController(AuthService service){
        this.service = service;
    }

    @PostMapping("/login")
    public ApiResponse<String> login(@RequestBody LoginRequest request){
        try{
            String token = service.login(request);
            return new ApiResponse<String>(true, token, "Inicio de Sesion correcto");
        }catch(BadCredentialsException e){
            return new ApiResponse<>(false, null, e.getMessage());
        }
    }

    @PostMapping("/register")
    public ApiResponse<Instructor> postMethodName(@RequestBody RegisterRequest request) {
        try{
            Instructor user = service.register(request);
            return new ApiResponse<Instructor>(true, user, "Usuario Registrado");
        }catch(BadCredentialsException e){
            return new ApiResponse<>(false, null, e.getMessage());
        }
    }
    
}
