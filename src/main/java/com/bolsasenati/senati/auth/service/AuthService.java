package com.bolsasenati.senati.auth.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bolsasenati.senati.auth.dto.LoginRequest;
import com.bolsasenati.senati.instructor.model.Instructor;
import com.bolsasenati.senati.instructor.repository.InstructorRepository;

public class AuthService {
    
    private final PasswordEncoder encoder;
    private final InstructorRepository repo;
    private final JwtService jwt;

    public AuthService(PasswordEncoder encoder, InstructorRepository repo, JwtService jwt){
        this.encoder = encoder;
        this.repo = repo;
        this.jwt = jwt;
    }

    public String login(LoginRequest credenciales){
        Instructor user = repo.findByCorreoInstitucional(credenciales.getCorreo()).orElseThrow(() -> new BadCredentialsException("Credenciales Incorrectas"));
        if(!encoder.matches(credenciales.getClave(), user.getClave())){
            throw new BadCredentialsException("Credenciales incorrectas");
        }
        return jwt.generateToken(user.getCorreoInstitucional());
    }
    
}
