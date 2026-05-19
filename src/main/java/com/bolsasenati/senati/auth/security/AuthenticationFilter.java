package com.bolsasenati.senati.auth.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.bolsasenati.senati.auth.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    private final JwtService service;
    private final UserDetailsService userDetailsService;

    public AuthenticationFilter(JwtService service, UserDetailsService userDetailsService){
        this.service = service;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filter)throws ServletException, IOException{
        //Obtener cabecera
        String authHeader = req.getHeader("Authorization");

        //Verificar que no este vacio y que comience como Bearer
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            filter.doFilter(req, res);
            return;
        }

        //Extraer Token
        String token = authHeader.substring(7);

        //Extraer correo del token
        String correo = service.ExtractEmail(token);

        //Verificar que el correo no sea nulo
        if(correo != null){

            //Mapear a UserDetails
            UserDetails userDetails = userDetailsService.loadUserByUsername(correo);

            //Verificar que el token no este vencido
            if (service.validateToken(token)) {


                UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities()
                );

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));

                //Colocar este request como authenticated
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filter.doFilter(req, res);
    }
}
