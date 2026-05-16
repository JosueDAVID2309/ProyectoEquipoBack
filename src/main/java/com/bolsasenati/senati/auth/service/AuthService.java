package com.bolsasenati.senati.auth.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bolsasenati.senati.auth.dto.LoginRequest;
import com.bolsasenati.senati.auth.dto.RegisterRequest;
import com.bolsasenati.senati.auth.mapper.UserMapper;
import com.bolsasenati.senati.instructor.model.Instructor;
import com.bolsasenati.senati.instructor.repository.InstructorRepository;

@Service
public class AuthService {
    
    private final PasswordEncoder encoder;
    private final InstructorRepository repo;
    private final JwtService jwt;
    private final UserMapper mapper;

    public AuthService(PasswordEncoder encoder,
            InstructorRepository repo,
            JwtService jwt,
            UserMapper mapper){
        this.encoder = encoder;
        this.repo = repo;
        this.jwt = jwt;
        this.mapper = mapper;
    }

    public String login(LoginRequest credenciales){
        Instructor user = repo.findByCorreoInstitucional(credenciales.getCorreo()).orElseThrow(() -> new BadCredentialsException("Credenciales Incorrectas"));
        if(!encoder.matches(credenciales.getClave(), user.getClave())){
            throw new BadCredentialsException("Credenciales incorrectas");
        }
        return jwt.generateToken(user.getCorreoInstitucional());
    }

    //ruta provisional
    public Instructor register(RegisterRequest request){
        if(repo.existsByCorreoPersonal(request.getCorreoPersonal())){
            throw new BadCredentialsException("Este correo ya existe dentro del sistema...");
        }
        Instructor user = mapper.toEntity(request);

        //Generar Credenciales
        user.setCorreoInstitucional(user.getDni()+"@senati.pe");
        user.setClave(encoder.encode(user.getEspecialidad()));

        repo.save(user);
        repo.flush();
        return user;
    }
    
}
