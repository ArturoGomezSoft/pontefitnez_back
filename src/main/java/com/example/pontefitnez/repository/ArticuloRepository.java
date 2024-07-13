package com.example.pontefitnez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pontefitnez.model.Articulo;

public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
    List <Articulo> findByNombreContaining(String nombre);
    Articulo findByNombre(String nombre);
}
