package com.example.demo.repository;

import com.example.demo.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
public interface CursoRepository extends JpaRepository<Curso, Long> {

    //Consultas
    @Query("SELECT c FROM Curso c")
    List<Curso>findAllCourses();
    @Query("SELECT c FROM Curso c WHERE c.fechaDeInicio > :fechaDeInicio")
    List<Curso>findCoursesByDate(@Param("fechaDeInicio") LocalDate fechaDeInicio);

    //Consultas derivadas
    //List<Curso> findAllCurso();
    List<Curso> findByFechaDeInicio(LocalDate fechaDeInicio);


}
