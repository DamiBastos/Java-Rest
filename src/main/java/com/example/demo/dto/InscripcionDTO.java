package com.example.demo.dto;

import com.example.demo.domain.Curso;
import com.example.demo.domain.Estado;
import com.example.demo.domain.Estudiante;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class InscripcionDTO {
        private Long id;
        private LocalDate fechaDeInscripcion;
        private Estado estado;
        private Curso curso;
        private Estudiante estudiante;
}
