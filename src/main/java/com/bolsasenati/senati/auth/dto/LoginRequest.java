package com.bolsasenati.senati.auth.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
public class LoginRequest {
    private String correo;
    private String clave;
}
