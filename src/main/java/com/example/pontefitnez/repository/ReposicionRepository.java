package com.example.pontefitnez.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pontefitnez.model.Reposicion;

public interface ReposicionRepository extends JpaRepository<Reposicion, Long> {
    @Query("SELECT p FROM Reposicion p WHERE p.fecha_hora BETWEEN :start AND :end")
    List <Reposicion> findByFecha_horaBetween(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
