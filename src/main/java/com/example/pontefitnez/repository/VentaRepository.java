package com.example.pontefitnez.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pontefitnez.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    @Query("SELECT v FROM Venta v WHERE v.fecha_hora BETWEEN :start AND :end")
    List <Venta> findByFecha_horaBetween(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
