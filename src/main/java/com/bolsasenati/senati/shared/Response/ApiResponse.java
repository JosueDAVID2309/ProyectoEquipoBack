package com.bolsasenati.senati.shared.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Data
@Setter
@Getter
public class ApiResponse<T> {
    private Boolean success;
    private T data;
    private String message;
}
