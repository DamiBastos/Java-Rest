package com.example.demo.repository;

import com.example.demo.domain.Estado;
import com.example.demo.domain.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    //Consultas
    @Query("SELECT c FROM Inscripcion c WHERE c.estado='RECHAZADO' OR c.estado='PENDIENTE'")
    List<Inscripcion> findAllRejectedOrPending();
    @Query("SELECT c FROM Inscripcion c WHERE c.estado = :estado")
    List<Inscripcion> findByState(@Param("estado") Estado estado);
    @Query(value="SELECT * FROM inscripcion c WHERE c.estado = :estado", nativeQuery =true)
    List<Inscripcion> findByStateNative(@Param("estado") Estado estado);

    //Consultas derivadas
    List<Inscripcion> findByEstadoIsOrEstadoIs(Estado denegado, Estado procesando);
    List<Inscripcion> findByEstado(String state);

}

