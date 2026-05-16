package com.bolsasenati.senati.auth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bolsasenati.senati.instructor.model.Instructor;
import com.bolsasenati.senati.instructor.repository.InstructorRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    
    private final InstructorRepository repo;
    
    public CustomUserDetailsService(InstructorRepository repo){
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String correo)throws UsernameNotFoundException{
        Instructor user = repo.findByCorreoInstitucional(correo).orElseThrow(()-> new UsernameNotFoundException("No existe un usuario con este correo")); 

        return org.springframework.security.core.userdetails.User
            .builder()
            .username(user.getCorreoInstitucional())
            .password(user.getClave())
            .build();
    }
}
