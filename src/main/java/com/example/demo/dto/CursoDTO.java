package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaDeInicio;
    private LocalDate fechaDeFin;
}
