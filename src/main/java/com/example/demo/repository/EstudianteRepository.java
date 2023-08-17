package com.example.demo.repository;

import com.example.demo.domain.Estudiante;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    // Consultas
    @Query("SELECT c FROM Estudiante c")
    List<Estudiante> findAllStudents();
    @Query("SELECT c FROM Estudiante c WHERE c.dni > 20000000 AND c.apellido='Romero'")
    List<Estudiante> findStudentsDniAndApellido();

    // Consultas Derivadas
    List<Estudiante> findByDniAndApellido(int dni, String apellido);

}
